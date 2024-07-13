package org.guava.example;

/**
 * @ClassName CustomerEmailExtractor
 * @Author：Mayuan
 * @Date 2024/7/13/星期六 16:34
 * @Description TODO
 * @Version 1.0
 **/

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import java.util.Collection;
import java.util.List;

public class CustomerEmailExtractor {
    static class Customer {
        String email;
        boolean isVerified;

        Customer(String email, boolean isVerified) {
            this.email = email;
            this.isVerified = isVerified;
        }

        String getEmail() {
            return email;
        }

        boolean isVerified() {
            return isVerified;
        }
    }

    public static void main(String[] args) {
        List<Customer> customers = Lists.newArrayList(
                new Customer("alice@example.com", true),
                new Customer("bob@example.com", false),
                new Customer("charlie@example.com", true)
        );

        // 提取验证过的电子邮件
        Collection<String> verifiedEmails = Collections2.filter(
                Collections2.transform(customers, customer -> customer.getEmail()),
                email -> email.endsWith("@example.com")
        );

        System.out.println(verifiedEmails);
    }
}
