package org.guava.example;

/**
 * @ClassName SalesAnalysis
 * @Author：Mayuan
 * @Date 2024/7/13/星期六 16:37
 * @Description TODO
 * @Version 1.0
 **/
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.List;

public class SalesAnalysis {
    static class SaleRecord {
        String product;
        double amount;

        SaleRecord(String product, double amount) {
            this.product = product;
            this.amount = amount;
        }

        double getAmount() {
            return amount;
        }
    }

    public static void main(String[] args) {
        List<SaleRecord> records = Lists.newArrayList(
                new SaleRecord("Laptop", 1200.00),
                new SaleRecord("Smartphone", 800.00),
                new SaleRecord("Tablet", 450.00)
        );

        // 过滤出高销售额的记录
        Collection<SaleRecord> highSales = Collections2.filter(records,
                new Predicate<SaleRecord>() {
                    @Override
                    public boolean apply(SaleRecord record) {
                        return record.getAmount() > 1000;
                    }
                });

        System.out.println(highSales);
    }
}
