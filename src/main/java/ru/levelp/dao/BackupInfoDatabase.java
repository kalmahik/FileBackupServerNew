package ru.levelp.dao;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import ru.levelp.entities.BackupInfo;

import java.util.List;

public class BackupInfoDatabase implements BackupInfoDao {
    private static final BackupInfoDatabase instance = new BackupInfoDatabase();

    private BackupInfoDatabase() {

    }

    public static BackupInfoDatabase getInstance() {
        return instance;
    }

    public void add(BackupInfo backupInfo) {

        Session session = HibernateManager.getInstance()
                .getSessionFactory()
                .openSession();
        session.beginTransaction();
        session.save(backupInfo);
        session.getTransaction().commit();
        session.close();
    }

    public BackupInfo get(int id) {
        Session session = HibernateManager.getInstance()
                .getSessionFactory()
                .openSession();
        BackupInfo backupInfo = (BackupInfo) session.createCriteria(BackupInfo.class)
                .add(Restrictions.eq("id", id)).uniqueResult();
        session.close();
        return backupInfo;
    }

    public List<BackupInfo> getAll() {
        Session session = HibernateManager.getInstance()
                .getSessionFactory()
                .openSession();
        List<BackupInfo> backupInfo = session.createCriteria(BackupInfo.class).list();
        session.close();
        return backupInfo;
    }

//    @Override
//    public BackupInfo remove(int id) {
//        Session session = HibernateManager.getInstance()
//                .getSessionFactory()
//                .openSession();
//        BackupInfo m = get(id);
//        session.delete(m);
//        session.getTransaction().commit();
//        session.close();
//        return m;
//    }
//
//    public List<BackupInfo> getHistory(String username) {
//        Session session = HibernateManager.getInstance()
//                .getSessionFactory()
//                .openSession();
//        List<BackupInfo> backupInfo = session.createCriteria(BackupInfo.class)
//                .add(Restrictions.or(
//                        Restrictions.eq("receiver", username),
//                        Restrictions.eq("sender", username),
//                        Restrictions.eq("receiver", "all")))
//                .list();
//        session.close();
//        return backupInfo;
//    }
}
