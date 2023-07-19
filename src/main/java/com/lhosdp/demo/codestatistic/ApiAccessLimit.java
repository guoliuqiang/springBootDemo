package com.lhosdp.demo.codestatistic;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * 上述代码中，我们使用了一个accessCounts的HashMap来保存每个用户的访问次数。
 * 在canAccessApi方法中，我们首先获取用户的当前访问次数。
 * 如果访问次数小于每天的最大访问次数，我们将访问次数加1，并返回true表示用户可以继续访问接口；否则，返回false表示用户已达到每天的最大访问次数。
 *
 * 在main方法中，我们创建了一个ApiAccessLimit对象，并模拟了用户访问接口的过程。
 * 根据每天的访问限制，我们通过循环调用canAccessApi方法来判断用户是否可以访问接口，并输出相应的结果。
 *
 * 请注意，以上示例是简化的实现，没有考虑到存储访问次数的持久化和每天重置访问次数的逻辑。
 * 在实际应用中，你可能需要将访问次数存储到数据库或其他持久化存储中，并在每天的特定时间点重置访问次数。
 */
public class ApiAccessLimit {

    private Map<String, Integer> accessCounts;  // 保存用户的访问次数
    private int maxAccessPerDay;  // 每天最大访问次数

    public ApiAccessLimit(int maxAccessPerDay) {
        this.accessCounts = new HashMap<>();
        this.maxAccessPerDay = maxAccessPerDay;
    }

    public boolean canAccessApi(String userId) {
        int accessCount = accessCounts.getOrDefault(userId, 0);
        if (accessCount < maxAccessPerDay) {
            accessCounts.put(userId, accessCount + 1);
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        ApiAccessLimit accessLimit = new ApiAccessLimit(10);

        // 模拟用户访问接口
        String userId = "user1";
        for (int i = 0; i < 12; i++) {
            if (accessLimit.canAccessApi(userId)) {
                System.out.println("User " + userId + " can access the API.");
            } else {
                System.out.println("User " + userId + " has reached the maximum limit of API access.");
            }
        }
    }
}

