package br.facens.guimagarotti.students.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import br.facens.guimagarotti.students.config.HibernateConfig;
import br.facens.guimagarotti.students.model.Student;
import jakarta.persistence.Query;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private final SessionFactory sessionFactory;

    public StudentRepositoryImpl() {
        this.sessionFactory = HibernateConfig.getSessionFactory();
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Student> findAll() {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        List<Student> students = session.createQuery("FROM Student", Student.class).getResultList();
        transaction.commit();
        return students;
    }

    @Override
    public Student findById(Long id) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        Student student = session.find(Student.class, id);
        transaction.commit();
        return student;
    }

    @Override
    public Student save(Student student) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(student);
        transaction.commit();
        return student;
    }

    @Override
    public String delete(int id) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();

        String hqlQuery = "DELETE FROM Student WHERE id = :studentId";
        @SuppressWarnings("deprecation")
        Query query = session.createQuery(hqlQuery);
        query.setParameter("studentId", id);

        int deletedCount = query.executeUpdate();
        transaction.commit();

        if (deletedCount > 0)
            return "Aluno deletado com sucesso!";
        else
            return "Não foi possível deletar o aluno desejado!";
    }
}
