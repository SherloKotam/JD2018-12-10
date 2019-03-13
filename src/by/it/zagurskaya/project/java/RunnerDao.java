package by.it.zagurskaya.project.java;


import by.it.zagurskaya.project.java.beans.*;
import by.it.zagurskaya.project.java.dao.*;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class RunnerDao {
//    ВАЖНО!!!! перед запуском запустить InitDataBase.java

    static Map<Class, Dao> daoMap = new HashMap<>();

    static {
        daoMap.put(Currency.class, new CurrencyDao());
    }

    public static void main(String[] args) throws SQLException {
        CurrencyDao currencyDao = new CurrencyDao();
        RateNBDao rateNBDao = new RateNBDao();
        RateCBDao rateCBDao = new RateCBDao();
        RoleDao roleDao = new RoleDao();
        UserDao userDao = new UserDao();
        DutiesDao dutiesDao = new DutiesDao();
        KassaDao kassaDao = new KassaDao();
        UserOperationDao userOperationDao = new UserOperationDao();
        UserEntryDao userEntryDao = new UserEntryDao();
        SprOperationsDao sprOperationsDao = new SprOperationsDao();
        SprEntriesDao sprEntriesDao = new SprEntriesDao();

        Currency currency = testCRU(currencyDao,
                new Currency(980, "test", "Тестовая валюта"),
                c -> c.setName("test_" + c.getName()));

        RateNB rateNB = testCRU(rateNBDao,
                new RateNB(0, currency.getId(), Date.valueOf("2019-02-20"), 3.45),
                c -> c.setSum(0.01 + c.getSum()));

        RateCB rateCB = testCRU(rateCBDao,
                new RateCB(0, currency.getId(), 933, Timestamp.valueOf("2019-02-20 15:45:00"), 3.40, false),
                c -> c.setSum(0.01 + c.getSum()));

        RateCB rateCBBack = testCRU(rateCBDao,
                new RateCB(0, 933, currency.getId(), Timestamp.valueOf("2019-02-20 15:45:00"), 3.42, true),
                c -> c.setSum(0.01 + c.getSum()));

        Role role = testCRU(roleDao,
                new Role(0, "TestRole"),
                r -> r.setName("test_" + r.getName()));

        User user = testCRU(userDao,
                new User(0, "TestUser", "TestUser", 2),
                r -> r.setLogin("Test" + r.getLogin()));

        Duties duties = testCRU(dutiesDao,
                new Duties(0, user.getId(), Timestamp.valueOf("2019-02-20 11:45:00"), 1, false),
                d -> d.setTimestamp(Timestamp.valueOf("2019-02-20 11:45:01")));

        List<Kassa> kassaList = currencyDao.getAll().stream()
                .map(c -> testCRU(kassaDao,
                        new Kassa(0, c.getId(), 0, 0, 0, 0, 0, user.getId(), Date.valueOf("2019-02-20"), duties.getNumber()),
                        k -> k.setReceived(100)))
                .collect(Collectors.toList());


        UserOperation userOperation = testCRU(userOperationDao,
                new UserOperation(0, Timestamp.valueOf("2019-02-20 12:45:00"), 1, 1000, 933, user.getId(), duties.getId(), 1000, "Подкрепление", "",null),
                r -> r.setSum(200 + r.getSum()));

        UserEntry userEntry = testCRU(userEntryDao,
                new UserEntry(0, userOperation.getId(), 100004, 933, "", "1010000000933", 1000, false, 1),
                r -> r.setSum(200 + r.getSum()));

        SprOperations sprOperations1 = testCRU(sprOperationsDao,
                new SprOperations(60, "Получено от клиентов", ""),
                r -> r.setName(r.getName() + "денежной наличности"));

        SprEntries sprEntries = testCRU(sprEntriesDao,
                new SprEntries(6001, "Получено денежной наличности (933)", 840, sprOperations1.getId(), null, "1010000000933", false, 1),
                r -> r.setCurrencyId(933));


        System.out.println();
        testD(userEntryDao, userEntry);
        testD(userOperationDao, userOperation);
        kassaList.forEach(k -> testD(kassaDao, k));
        testD(dutiesDao, duties);
        testD(roleDao, role);
        testD(userDao, user);
        testD(rateCBDao, rateCBBack);
        testD(rateCBDao, rateCB);
        testD(rateNBDao, rateNB);
        testD(currencyDao, currency);

    }

    private static <E extends Entity> E testCRU(Dao<E> entityDao, E entity, Consumer<E> updateConsumer) {
        try {
            System.out.println();
            System.out.println(entity);
            if (entityDao.create(entity)) {
                System.out.println("CREATE OK: " + entity);
            }
            updateConsumer.accept(entity);
            if (entityDao.update(entity)) {
                System.out.println("UPDATE OK: " + entity);
            }
            entity = entityDao.read(entity.getId());
            if (entity != null) {
                System.out.println("READ   OK: " + entity);
            }
            return entity;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static <E extends Entity> E testCRU(E entity, Consumer<E> updateConsumer) {
        try {
            Dao entityDao = daoMap.get(entity.getClass());

            if (entityDao.create(entity)) {
                System.out.println("CREATE OK: " + entity);
            }
            updateConsumer.accept(entity);
            if (entityDao.update(entity)) {
                System.out.println("UPDATE OK: " + entity);
            }
            entity = (E) entityDao.read(entity.getId());
            if (entity != null) {
                System.out.println("READ   OK: " + entity);
            }
            return entity;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static <E extends Entity> void testD(Dao<E> entityDao, E entity) {
        try {
            System.out.println(entity);
            if (entityDao.delete(entity)) {
                System.out.println("DELETE OK: " + entity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
