package test;

import utils.ConstructPropertySQLStmt;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public class TestSQLStmt {
    public static void main(String[] args) {
        System.out.println(ConstructPropertySQLStmt.getSelectStmt("Apartment & Unit", -1, 100, -1
                , 1000000000,3008));
    }
}
