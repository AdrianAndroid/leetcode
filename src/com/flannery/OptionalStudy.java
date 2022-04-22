package com.flannery;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.junit.Test;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.function.Predicate;

public class OptionalStudy {

    static class Employee {
        private Long id;
        private String name;
        private Boolean leader;

        public Employee(Long id, String name, Boolean leader) {
            this.id = id;
            this.name = name;
            this.leader = leader;
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public boolean getLeader() {
            return leader;
        }
        public boolean getLeader3(Optional<Employee> employee) {
            return true;
        }

        public static boolean getLeader2(Optional<Employee> employee) {
            return false;
        }
    }

    static class Leader {
        private Long employeeId;
        private BigDecimal bonus;

        public Leader(Long employeeId, BigDecimal bonus) {
            this.employeeId = employeeId;
            this.bonus = bonus;
        }

        public Long getEmployeeId() {
            return employeeId;
        }

        public BigDecimal getBonus() {
            return bonus;
        }
    }

    private Optional<Employee> getEmployeeById(Long id) {
        return Optional.of(new Employee(1L, "大老板", Boolean.FALSE));
    }

    private Optional<Leader> getLeaderById(Long employeeId) {
        return employeeId == 1L ? Optional.of(new Leader(1L, null)) : Optional.empty();
    }

    @Test
    public void tst() {
        Optional<Leader> leader =
                Optional.of(getEmployeeById(1L))
                .filter(Employee::getLeader2)
                .map(Employee::getId)
                .flatMap(this::getLeaderById)
                .orElse(null);
        if (leader.isPresent()) {
            Optional.of(leader.map(Leader::getBonus)
                    .map(bonus->String.format("员工ID的leader是:%s", bonus))
                    .orElse("员工ID为1的ledaer也没有奖金"))
                    .ifPresent(System.out::println);
        } else {
            System.out.println("员工ID为1的leader未找到，他可能知识一个基层员工，不配拥有奖金");
        }
    }

}
