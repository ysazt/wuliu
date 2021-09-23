package com.wuliu.entity;

public  class TestEntity {

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public static void main(String[] args) {
        TestEntity testEntity = new TestEntity();
        System.out.println(testEntity);

        TestEntity testEntity1 = new TestEntity();
        System.out.println(testEntity1);

        System.out.println(testEntity.hashCode() == testEntity1.hashCode());
    }

    @Override
    public String toString() {
        return "TestEntity{}";
    }
}


