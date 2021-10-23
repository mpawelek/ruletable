package com.github.mpawelek;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import jakarta.persistence.Persistence;

public class MainTest {
    @Test
    public void test() {
        var emf = Persistence.createEntityManagerFactory("h2/a");
        var em = emf.createEntityManager();
        try {
          // save
          RuleTable ruleTable1 = new RuleTable();
          ruleTable1.setEvaluationMathod(new SimpleEvaluationMethod());
          em.getTransaction().begin();
          em.persist(ruleTable1);
          em.getTransaction().commit();

          RuleTable ruleTable2 = new RuleTable();
          ruleTable2.setEvaluationMathod(new OrdinaryEvaluationMethod());
          em.getTransaction().begin();
          em.persist(ruleTable2);
          em.getTransaction().commit();

          // read
          RuleTable t1 = em.find(RuleTable.class, ruleTable1.getId());
          assertTrue(t1.getEvaluationMathod() instanceof SimpleEvaluationMethod);
          System.out.println(t1.getEvaluationMathod().evaluate());

          RuleTable t2 = em.find(RuleTable.class, ruleTable2.getId());
          assertTrue(t2.getEvaluationMathod() instanceof OrdinaryEvaluationMethod);
          System.out.println(t2.getEvaluationMathod().evaluate());
        } finally {
            if (em != null) {
                em.close();
                emf.close();
            }
        }
    }
}
