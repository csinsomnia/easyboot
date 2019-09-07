package io.keyell.ibatis;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import io.keyell.ibatis.domain.Employee;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

/**
 * @author huangke 创建于 2019-09-06
 */
public class IbatisMain {

    public static void main(String[] args)
            throws IOException, SQLException {
        Reader rd = Resources.getResourceAsReader("ibatis/sql-map-config.xml");
        SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);

        // INSERT
//        System.out.println("Going to insert record.....");
//        Employee em = new Employee("Zara", "Ali", 5000);
//        smc.insert("Employee.insert", em);

        // INSERT 缺失字段的插入
//        System.out.println("Going to insert record.....");
//        Map emMap = new HashMap();
//        emMap.put("last_name", "HUANG");
//        smc.insert("Employee.insertSomeFields", emMap);

        // INSERT NULL VALUE的插入
//        Employee emNull = new Employee();
//        smc.insert("Employee.insertWithNull", emNull);

//        Map emMapAll = new HashMap();
//        emMapAll.put("last_name", "HUANG");
        // java.sql.SQLException: Column count doesn't match value count at row 1
//        smc.insert("Employee.insertAllFields", emMapAll);


        // FIXME: MySQL自增的Key Id=0，如果数据库到了100，Id会插入101，指明了99可以插入99
        // FIXME: 指明了0 也会插入101
        Employee emAll = new Employee();
        emAll.setId(0);
        smc.insert("Employee.insertAllFields", emAll);


//        // UPDATE
//        Employee rec = new Employee();
//        rec.setId(1);
//        rec.setFirst_name("Roma2");
//        smc.update("Employee.update", rec);
//
//        // QUERY
//        List<Employee> ems = (List<Employee>)
//                smc.queryForList("Employee.getAll", null);
//
//        Employee emx = null;
//        for (Employee e : ems) {
//            System.out.print(" " + e.getId());
//            System.out.print(" " + e.getFirst_name());
//            System.out.print(" " + e.getLast_name());
//            System.out.print(" " + e.getSalary());
//            emx = e;
//            System.out.println("");
//        }
//
//        //DELETE
//        int id = 1;
//        smc.delete("Employee.delete", id);


//        int id = 2;
//        System.out.println("Going to read record.....");
//        Employee e = (Employee) smc.queryForObject
//                ("Employee.useResultMap", id);
//        System.out.println("ID: " + e.getId());
//        System.out.println("First Name: " + e.getFirst_name());
//        System.out.println("Last Name: " + e.getLast_name());
//        System.out.println("Salary: " + e.getSalary());
//
//
////        // 调用存储过程
//        id = 2;
//        Map map = new HashMap();
//        map.put("acctID", new Integer(id));
//        System.out.println("Going to read employee name.....");
//        e = (Employee) smc.queryForObject
//                ("Employee.getEmpInfo", map);
////                ("Employee.getEmpInfo", id);
//        System.out.println("First Name: " + e.getFirst_name());

        // 使用 useParameterMap
//        id = 3;
//        Map map = new HashMap();
//        map.put("acctID", new Integer(id));
//        System.out.println("Going to read employee name.....");
//        e = (Employee) smc.queryForObject
//                ("Employee.useParameterMap", map);
//        System.out.println("First Name: " + e.getFirst_name());


    }
}
