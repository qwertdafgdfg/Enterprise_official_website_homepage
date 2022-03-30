package cn.nwinfo.exhibition.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author OAT
 */
public class DateUtil {
    //以下定义的是一些时间格式常量
    /**
     * DATETIME_PATTERN(String):yyyy-MM-dd HH:mm:ss.
     */
    public static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DATETIME_NORMAL_PATTERN = "yyyy-MM-dd HH:mm";

    /**
     * DATE_PATTERN(String):yyyy-MM-dd.
     */
    public static final String DATE_PATTERN = "yyyy-MM-dd";

    /**
     * MONTH_PATTERN(String):yyyy-MM.
     */
    public static final String MONTH_PATTERN = "yyyy-MM";

    /**
     * 转换为字符串.
     */
    public static String toString(Date date, String pattern) {
        String result = null;

        if (date != null) {
//            result = DateFormatUtils.format(date, pattern);
        }

        return result;
    }

    public static Date toDate(String date) throws ParseException {
        Date dateResult = null;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        if (date != null && !"".equals(date)) {
            dateResult = sf.parse(date);
        }

        return dateResult;
    }

    /**
     * 获取当前时间的年和月
     */

    public static String getCurYearMonth() {
        int year;
        int month;
        String date;
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        date = year + "年" + (month < 10 ? "0" + month : month) + "月";
        return date;
    }

    /**
     * 获取指定日期同一年的第一天.
     */
    public static Date getFirstDateOfYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_YEAR, 1);
        return cal.getTime();
    }

    /**
     * 获取指定日期同一年的最后一天.
     */
    public static Date getLastDateOfYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getFirstDateOfYear(date));
        cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) + 1);
        cal.add(Calendar.DAY_OF_YEAR, -1);
        return cal.getTime();
    }

    /**
     * 指定日期追加指定年数.
     */
    public static Date addYear(Date date, int year) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, year);
        return cal.getTime();
    }

    /**
     * 获取给定时间同月份的第一天.
     */
    public static Date getFirstDateOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return cal.getTime();
    }

    /**
     * 获取给定时间同月份的第一天,且00:00:00 0.
     */
    public static Date getMonthOfDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取给定时间同月份的最后一天.
     */
    public static Date getLastDateOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getFirstDateOfMonth(date));
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);
        cal.add(Calendar.DAY_OF_YEAR, -1);
        return cal.getTime();
    }

    /**
     * 给指定的时间追加指定的月数.
     */
    public static Date addMonth(Date date, int month) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, month);
        return cal.getTime();
    }

    /**
     * 获取指定日期同周的星期一.
     */
    public static Date getFirstDateOfWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTime();
    }

    /**
     * 获取指定日期同周的星期日.
     */
    public static Date getLastDateOfWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return cal.getTime();
    }

    /**
     * 给指定日期追加指定的周数.
     */
    public static Date addWeek(Date date, int week) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.WEEK_OF_YEAR, week);
        return cal.getTime();
    }

    /**
     * 给指定时间追加指定秒.
     */
    public static Date addSecond(Date date, int second) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
//        c.add(Calendar.DATE, day);
        c.add(Calendar.SECOND, second);

        return c.getTime();
    }

    //追加天。
    public static Date addDay(Date date, int day) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, day);

        return c.getTime();
    }

    /**
     * 给指定时间追加指定的小时.
     */
    public static Date addHour(Date date, int hour) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.HOUR_OF_DAY, hour);

        return c.getTime();
    }

    /**
     * 给指定时间追加指定的分钟数.
     */
    public static Date addMinute(Date date, int minute) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MINUTE, minute);

        return c.getTime();
    }

    /**
     * 获取传入的两个时间的天数差
     *
     * @param date1 时间一
     * @param date2 时间二
     * @return 天数差
     */
    public static int getIntervalDateMinusDate(Date date1, Date date2) {
        return (int) ((date1.getTime() - date2.getTime()) / (1000 * 3600 * 24));
    }

    /**
     * 传入的时间字符串 获取传入时间的下一天0点0分0秒
     *
     * @param date String类型
     * @return 传入时间的下一天0点0分0秒
     */
    public static Date getNextDay(String date) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTemp = null;
        try {
            dateTemp = format.parse(date);
            Calendar calendar = Calendar.getInstance();

            calendar.setTime(dateTemp); //需要将date数据转移到Calender对象中操作
            calendar.add(Calendar.DATE, 1);//把日期往后增加n天.正数往后推,负数往前移动
            dateTemp = calendar.getTime();   //这个时间就是日期往后推一天的结果
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateTemp;
    }

    public static Date getNextDay(Date day) {
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(day); //需要将date数据转移到Calender对象中操作
        calendar.add(Calendar.DATE, 1);//把日期往后增加n天.正数往后推,负数往前移动
        Date dateTemp = calendar.getTime();   //这个时间就是日期往后推一天的结果

        return dateTemp;
    }

    public static Date getPreviousDay(Date day) {
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(day); //需要将date数据转移到Calender对象中操作
        calendar.add(Calendar.DATE, -1);//把日期往后增加n天.正数往后推,负数往前移动
        Date dateTemp = calendar.getTime();   //这个时间就是日期往后推一天的结果

        return dateTemp;
    }

    /**
     * 获取某个时间点之前的时间
     *
     * @param dateFormatStr 时间格式
     * @param dataStr       指定的时间
     * @param calendarType  Calendar类中的字段属性值   ERA = 0 、YEAR = 1、MONTH = 2、WEEK_OF_YEAR = 3、WEEK_OF_MONTH = 4.......,具体可查看   *                                          Calendar类
     * @param beforeNum     时间间隔数  根据calendarType   确定是年  月 日 等
     * @return beforeDateStr
     */
    public static String getBeforeDateStr(String dateFormatStr, String dataStr, int calendarType, int beforeNum) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormatStr);
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(sdf.parse(dataStr));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        calendar.add(calendarType, -beforeNum);
        Date beforeDate = calendar.getTime();
        return sdf.format(beforeDate);
    }

    /**
     * 根据指定日期获得指定日期所在周的周一到周天的日期 *
     *
     * @param mdate Date类型
     * @return 所在周的周一到周天的日期
     */
    public static List<Date> dateToCurrentWeek(Date mdate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(mdate);

        int b = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (b == 0) {
            b = 7;
        }
        Date fdate;
        List<Date> list = new ArrayList<>();
        long fTime = mdate.getTime() - (long) b * 24 * 3600000;
        for (int a = 1; a <= 7; a++) {
            fdate = new Date();
            fdate.setTime(fTime + (a * 24 * 3600000));
            list.add(a - 1, fdate);
        }
        return list;
    }

    /**
     * 传入日期计算自然周的开始结束时间
     * DATETIMENORMAL_PATTERN  是类里面定义的类变量的日期格式   请看该博客
     * 最开始给的类的属性
     */
    public static String[] getWeekDayBeginDateAndEndDateWithDateStr(Date date) {
        String[] beStr = new String[2];
        SimpleDateFormat formt = new SimpleDateFormat(DATETIME_NORMAL_PATTERN);
        List<Date> list = dateToCurrentWeek(date);
        beStr[0] = formt.format(list.get(0));
        beStr[1] = formt.format(list.get(6));
        return beStr;
    }

    public static long getDistanceDays(String str1, String str2) {
        DateFormat df = new SimpleDateFormat(DATE_PATTERN);   //DATE_PATTERN  是类里面定义的类变量的日期格式  请看该博客最开始给的类的属性
        Date one;
        Date two;
        long day = 0;
        try {
            one = df.parse(str1);
            two = df.parse(str2);
            long time1 = one.getTime();
            long time2 = two.getTime();
            long diff;
            if (time1 < time2) {
                diff = time2 - time1;
            } else {
                diff = time1 - time2;
            }
            day = diff / (24 * 60 * 60 * 1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return day;
    }

    public static long[] getLateDistanceTimes(String beginDate, String endDate) {
        DateFormat df = new SimpleDateFormat(DATETIME_PATTERN);  //DATETIME_PATTERN  是类里面定义的类变量的日期格式  请看该博客最开始给的类的属性
        Date one;
        Date two;
        long day = 0;
        long hour = 0;
        long min = 0;
        long sec = 0;
        try {
            one = df.parse(beginDate);
            two = df.parse(endDate);
            long time1 = one.getTime();
            long time2 = two.getTime();
            long diff;
            if (time1 < time2) {
                diff = time2 - time1;
                day = diff / (24 * 60 * 60 * 1000);
                hour = (diff / (60 * 60 * 1000) - day * 24);
                min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
                sec = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new long[]{day, hour, min, sec};
    }

    public static List<String> getDays(String startTime, String endTime) {
        // 返回的日期集合
        List<String> days = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);  //DATE_PATTERN  是类里面定义的类变量的日期格式  请看该博客最开始给的类的属性
        try {
            Date start = dateFormat.parse(startTime);
            Date end = dateFormat.parse(endTime);
            Calendar tempStart = Calendar.getInstance();
            tempStart.setTime(start);
            Calendar tempEnd = Calendar.getInstance();
            tempEnd.setTime(end);
            tempEnd.add(Calendar.DATE, +1);// 日期加1(包含结束)
            while (tempStart.before(tempEnd)) {
                days.add(new SimpleDateFormat("MM-dd").format(tempStart.getTime()));
                tempStart.add(Calendar.DAY_OF_YEAR, 1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return days;
    }

    /**
     * @return 通过传递时间段去获取该时间段中的每天日期
     * //     * @throws ParseException 开始时间和结束时间请传递类似于2018-12-12这样的时间-字符串
     * //     *                        DATE_PATTERN  是类里面定义的类变量的日期格式  请看该博客最开始给的类的属性
     */
    public static Date[] getDateArrays(String startPar, String endPar, int calendarType) {
        SimpleDateFormat sd = new SimpleDateFormat(DATE_PATTERN);
        Date start = null;
        Date end = null;
        try {
            start = sd.parse(startPar);
            end = sd.parse(endPar);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ArrayList<Date> ret = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        assert start != null;
        calendar.setTime(start);
        Date tmpDate = calendar.getTime();
        assert end != null;
        long endTime = end.getTime();
        while (tmpDate.before(end) || tmpDate.getTime() == endTime) {
            ret.add(calendar.getTime());
            calendar.add(calendarType, 1);
            tmpDate = calendar.getTime();
        }
        Date[] dates = new Date[ret.size()];
        return ret.toArray(dates);
    }

    /**
     * @return 通过传递时间参数，判断这天是星期几，如"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"
     * 请传递类似于2018-12-12这样的时间
     */
    public static String getWeekDayByDate(Date date) {
        Calendar cal = Calendar.getInstance();
        String[] weekOfDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        return weekOfDays[w];
    }

    /**
     * @return 通过传递时间参数，判断这天是星期几，如"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"
     * //     * @throws ParseException 请传递类似于2018-12-12这样的时间字符串
     */
    public static String getWeekDayByDateStr(String dateStr) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat formt = new SimpleDateFormat(DATE_PATTERN);
        Date date = null;
        try {
            date = formt.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assert date != null;
        cal.setTime(date);
        String[] weekOfDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        return weekOfDays[w];
    }

    /**
     * @return 今天是星期几，如"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"
     */
    public static String getWeekDay() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        String[] weekOfDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        return weekOfDays[w];
    }

    /**
     * @return 通过传递时间参数，判断这天是几月，如"一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"
     * //     * @throws ParseException 请传递类似于2018-12-12这样的时间
     */
    public static String getMonthByDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String[] monthOfYear = {"一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"};
        int m = cal.get(Calendar.MONTH);
        return monthOfYear[m];
    }

    /**
     * 获取传入时间的当前月
     */
    public static int getMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取传入时间的当前年
     */
    public static int getYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }

    /**
     * 获取传入时间的当月总共天数
     */
    public static int getDays(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public static Date stringToDate(String dateStr, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException ignored) {
        }
        return date;
    }

    /**
     * 获取to和from之间的月份差，例：from为2020-01，to为2020-02，所获结果为2
     *
     * @param from 开始月份
     * @param to   结束月份
     * @return 两者之差
     */
    public static int getDistanceMonths(Date from, Date to) {
        Calendar cal = Calendar.getInstance();

        cal.setTime(from);
        int fromYear = cal.get(Calendar.YEAR);
        int fromMonth = cal.get(Calendar.MONTH);

        cal.setTime(to);
        int toYear = cal.get(Calendar.YEAR);
        int toMonth = cal.get(Calendar.MONTH);
        return (toYear - fromYear) * 12 + (toMonth - fromMonth) + 1;
    }

    /**
     * 获取传入季度(字符串2020-Q1)的Date形式
     *
     * @param quarter 2020-Q1
     * @return date
     */
    public static Date getDateByQuarter(String quarter) {
        String year = quarter.substring(0, 4);
        int quart = Integer.parseInt(quarter.substring(6)) * 3 - 2;
        if (quart == 10) {
            year += "-" + quart;
        } else {
            year += "-" + 0 + quart;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(MONTH_PATTERN);
        Date date = null;
        try {
            date = sdf.parse(year);
        } catch (ParseException ignored) {
        }
        return date;
    }

    /**
     * @param date yyyy-02
     * @return yyyy-Q1
     */
    public static String getQuarterByDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR) + "-Q" + (calendar.get(Calendar.MONTH) / 3 + 1);
    }

    /**
     * Description: 判断一个时间是否在一个时间段内 </br>
     *
     * @param nowTime   当前时间 </br>
     * @param beginTime 开始时间 </br>
     * @param endTime   结束时间 </br>
     */
    public static boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        return date.after(begin) && date.before(end);

    }

    //向日期添加时分秒。
    public static Date addHourMinuteSecond(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
//        calendar.add(Calendar.HOUR, -24);
//        calendar.add(Calendar.MINUTE, 59);
        calendar.add(Calendar.SECOND, -1);
//        calendar.add(Calendar.MILLISECOND, 999);

        return calendar.getTime();
    }


    /**
     * 判断当前时间与给定时间差是否大于10分钟
     *
     * @param date
     * @return 大于10分钟返回true, 就是解锁了。
     * @throws Exception
     */
    public static boolean localTimeGivenTime(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = null;
        try {
            now = sdf.parse(sdf.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
//            throw new BadRequestException("Wrong ParseException ！");
        }
        if (now.getTime() - date.getTime() >= 10 * 60 * 1000) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 功能描述  因为时间格式字符串不能用来作为文件名或者文件夹名所以需要进行装换。
     *
     * @param date
     * @return java.lang.String
     * @author liYuan
     * @date 2022/3/26 11:02
     */
    public static String convertedSpecifiedString(Date date) {
        return DateUtil.toString(date, DateUtil.DATETIME_PATTERN).replaceAll(":", "_").replaceAll(" ", "_").replaceAll("-", "_");
    }

    public static void main(String[] args) {
        System.out.println("main");
    }
}
