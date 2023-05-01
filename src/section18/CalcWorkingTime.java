package section18;

import java.sql.Time;

public class CalcWorkingTime {

    private final long ONE_HOUR_BY_MILLI_SEC = 1000 * 60 * 60; // 1時間のミリ秒換算
    private final long ONE_MIN_BY_MILLI_SEC = 1000 * 60;      // 1分のミリ秒換算
    private final int ONE_HOUR_BY_MIN = 60;             // 1時間の分換算

    private final int HOURLY_WAGE = 900;

    public static void main(String[] args) {
        CalcWorkingTime c = new CalcWorkingTime();
        c.mainCalucu(args);
    }

    public void mainCalucu(String[] args) {

        args = new String[]{"09:30:00", "15:00:00"};
        long[] actualWorkingTimeAndRestTime = this.caluculateActualWorkTimeAndRestTime(args);
        long actualWorkingTime = actualWorkingTimeAndRestTime[0];
        long restTime = actualWorkingTimeAndRestTime[1];
        displayWorkTime(actualWorkingTime);

        int actualFee = getActualFee(actualWorkingTime);
        System.out.println("給与は%s円です。".formatted(actualFee));

    }

    public int caluculateTodayWorkFee(long baseWorkingTime) {
        long restTime = this.needRestTime(baseWorkingTime);
        long actualWorkingTime = baseWorkingTime - restTime;
        int actualFee = getActualFee(actualWorkingTime);

        return actualFee;
    }

    private int getActualFee(long actualWorkingTime) {
        int workingHour = this.convertWokingHour(actualWorkingTime);

        int overTimeFee = 0;
        int normalWorkFee = 0;
        if (workingHour > 8) {
            long overWorkTime = actualWorkingTime - ONE_HOUR_BY_MILLI_SEC * 8;
            overTimeFee = (int) ((((double) overWorkTime/ ONE_HOUR_BY_MILLI_SEC) * HOURLY_WAGE) * 1.25);
            normalWorkFee = 8 * HOURLY_WAGE;
        } else  {
            normalWorkFee = (int) (((double)actualWorkingTime / ONE_HOUR_BY_MILLI_SEC) * HOURLY_WAGE);
        }

        return normalWorkFee + overTimeFee;
    }

    private void displayWorkTime(long actualWorkingTime) {
        int workingHour = this.convertWokingHour(actualWorkingTime);
        int workingMin = this.convertWorkngMin(actualWorkingTime);

        System.out.println("本日の労働時間は" + workingHour + "時間" + workingMin + "分です。");
    }

    private long[] caluculateActualWorkTimeAndRestTime(String[] args) {
        long baseWorkingTime = this.getBaseWorkingTime(args);
        long restTime = this.needRestTime(baseWorkingTime);
        long actualWorkingTime = baseWorkingTime - restTime;

        return new long[]{actualWorkingTime, restTime};
    }


    private long needRestTime(long baseWorkingTime) {
        long sixHour = ONE_HOUR_BY_MILLI_SEC * 6;
        long eightHour = ONE_HOUR_BY_MILLI_SEC * 8;

        if (baseWorkingTime < sixHour) {
            return 0;
        }
        if (sixHour < baseWorkingTime && baseWorkingTime < eightHour) {
            return ONE_MIN_BY_MILLI_SEC * 45;
        }
        return ONE_HOUR_BY_MILLI_SEC;
    }

    private int convertWokingHour(long workTime) {
        return (int) (workTime / ONE_HOUR_BY_MILLI_SEC);
    }

    private int convertWorkngMin(long actualWorkingTime) {
        return (int) ((actualWorkingTime / ONE_MIN_BY_MILLI_SEC) % ONE_HOUR_BY_MIN);
    }

    private long getBaseWorkingTime(String[] args) {
        Time startTime = Time.valueOf(args[0]);
        Time finishTime = Time.valueOf(args[1]);

        return finishTime.getTime() - startTime.getTime();
    }
}
