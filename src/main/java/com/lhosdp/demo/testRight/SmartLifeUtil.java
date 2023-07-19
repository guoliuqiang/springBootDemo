package com.lhosdp.demo.testRight;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
public class SmartLifeUtil {

	private SmartLifeUtil() {
	}

	static private final DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	static private final DateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
	static public final String CURRENT_DATE_PREFIX = "CURRENT_DATE";

	static public String generateFlowNo(long value, String pattern) {
		String retValue = convertKey(value, pattern);
		if (pattern.startsWith(CURRENT_DATE_PREFIX)) {
			String date = dateFormat.format(new Date());
			return date + retValue;
		} else {
			return retValue;
		}
	}



	static private String convertKey(long value, String pattern) {
		String v = String.valueOf(value);
		int length = v.length();
		StringBuffer buffer = new StringBuffer();
		int limited = pattern.length();
		if(pattern.startsWith(CURRENT_DATE_PREFIX))
			limited-=CURRENT_DATE_PREFIX.length();
		for (int i = 1; i <= limited; i++) {
			if (length >= i) {
				char c = v.charAt(length - i);
				buffer.insert(0, c);
			} else {
				buffer.insert(0, '0');
			}
		}
		return buffer.toString();
	}

	static public String formatDate(Date date){
		return dateFormat.format(date);
	}
	static public String formatDateyyyymmdd(Date date){
		return yyyyMMdd.format(date);
	}

	final private static double EARTH_RADIUS = 6378.137;

	static private double rad(double d) {
        return d * Math.PI / 180.0;
    }

	static private double getInterval(double distance) {
        return 360 * distance / (2 * Math.PI * EARTH_RADIUS);
    }

    /**
     * 计算两个坐标点间的距离
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @return
     */
    static public double getDistance(double lat1, double lng1, double lat2, double lng2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);

        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) +
                Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
        s = s * EARTH_RADIUS;
        //s = Math.round(s * 10000) / 10000;
        return s;
    }

    /**
     * 计算以一点为中心的正方形四顶点坐标
     * @param distance
     * @param lat
     * @param lng
     * @return
     */
    static public double[] getArea(double distance, double lat, double lng) {
    	double interval = getInterval(distance);
        double[] areas = new double[4];
        areas[0] = lat - interval;
        areas[1] = lng - interval;
        areas[2] = lat + interval;
        areas[3] = lng + interval;
        return areas;
    }

    /** 配置访问链接 **/
    static private String CRM_URL = "";
    static private String IMAGE_URL = "";
    static private String WEIXIN_URL = "";
    static private String WEIXIN_CRM_URL = "";
    static private String WEB_URL = "";

    public static void setCrmUrl(String crmUrl) {
		CRM_URL = crmUrl;
	}
    public static String getCrmUrl() {
		return CRM_URL;
	}
    public static void setImageUrl(String imageUrl) {
    	IMAGE_URL = imageUrl;
	}
    public static String getImageUrl() {
		return IMAGE_URL;
	}
    public static void setWeixinUrl(String weixinUrl) {
		WEIXIN_URL = weixinUrl;
	}
    public static String getWeixinUrl() {
		return WEIXIN_URL;
	}
    public static void setWeixinCrmUrl(String weixinCrmUrl) {
		WEIXIN_CRM_URL = weixinCrmUrl;
	}
    public static String getWeixinCrmUrl() {
		return WEIXIN_CRM_URL;
	}
    public static void setWebUrl(String webUrl) {
		WEB_URL = webUrl;
	}
    public static String getWebUrl() {
		return WEB_URL;
	}

	/**
	 * 产生一个随机的字符串
	 * @param length
	 * @return
	 */
	public static String randomString(int length) {
		String seed = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int num = random.nextInt(seed.length());
			buf.append(seed.charAt(num));
		}
		return buf.toString();
	}

	/**
	 * 产生一个随机的数字串
	 * @param length
	 * @return
	 */
	public static String randomNumber(int length) {
		String seed = "0123456789";
		Random random = new Random();
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int num = random.nextInt(seed.length());
			buf.append(seed.charAt(num));
		}
		return buf.toString();
	}


	static private final ObjectMapper objectMapper = new ObjectMapper();
	/**
	 * json字符串转化为Object
	 * @param json
	 * @param className
	 * @return
	 */
	static public <T> T parseJson(String json, Class<T> className){
		try {
			JsonParser parser = objectMapper.getFactory().createParser(json);
			return objectMapper.readValue(parser, className);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * jsonArray字符串转化为List<Object>
	 * @param json
	 * @param type
	 * @return
	 */
	static public <T> List<T> parseJsonList(String json, Class<T> type){
		try {
			JsonParser parser = objectMapper.getFactory().createParser(json);
			return objectMapper.readValue(parser, objectMapper.getTypeFactory().constructCollectionType(List.class, type));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	static public <T> T parseJson(String json, TypeReference<T> className){
		try {
			JsonParser parser = objectMapper.getFactory().createParser(json);
			return objectMapper.readValue(parser, className);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * 过滤Emoji字符
	 * @param src
	 * @return
	 */
	public static String filterEmojiString(String src){
		return src.replaceAll("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\ud83e\udc00-\ud83e\udfff]|[\u2600-\u27ff]", "?");
	}

	/**
	 * Object转化为json字符串
	 * @param obj
	 * @return
	 */
	static public String generateObject(Object obj){
		OutputStream sos = new ByteArrayOutputStream();
		try {
			JsonGenerator generator = objectMapper.getFactory().createGenerator(sos, JsonEncoding.UTF8);
			objectMapper.writeValue(generator, obj);
			return sos.toString();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}


	/*public static void main(String[] args) {
		String s = "😀💩💩💩高琳1😆||\ud83e\udd17||\uD83C\uDE1A||\uD83E\uDD11||";
		System.out.println(s);
		System.out.println(filterEmojiString(s));
		try {
			byte[] b = s.getBytes("utf8");
			System.out.println(b.length);
		} catch (UnsupportedEncodingException e) {
		}
	}*/

	/**
	 * 对比两个时间是不是同一天
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean isSameDay(Date date1, Date date2) {
		if(date1 != null && date2 != null) {
			Calendar cal1 = Calendar.getInstance();
			cal1.setTime(date1);
			Calendar cal2 = Calendar.getInstance();
			cal2.setTime(date2);
			return isSameDay(cal1, cal2);
		} else {
			throw new IllegalArgumentException("The date must not be null");
		}
	}

	public static boolean isSameDay(Calendar cal1, Calendar cal2) {
		if(cal1 != null && cal2 != null) {
			return cal1.get(0) == cal2.get(0) && cal1.get(1) == cal2.get(1) && cal1.get(6) == cal2.get(6);
		} else {
			throw new IllegalArgumentException("The date must not be null");
		}
	}

	public static String generateUUID(){
		return UUID.randomUUID().toString().replace("-","");
	}

	/**
	 * 获取当前时间的月底最后一秒的时间
	 * @return
	 */
	public static Date getNowDateMouthend(Date date) throws Exception{
		//设置时间格式
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//获得实体类
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		//设置最后一天
		ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
		//最后一天格式化
		String lastDay = format.format(ca.getTime());
		String dateend =  lastDay + " 23:59:59";
		return simpleDateFormat.parse(dateend);
	}

    /**
     * 获取当前月份开始时间
     * @return
     * @throws Exception
     */
	public static Date getNowDateMouthStart() throws Exception{
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return simpleDateFormat.parse(myFormatter.format(cal.getTime())+ " 00:00:00");
	}

	/**
	 * 判断两时间月份是否相同
	 */
	public static Boolean isSameMouth(Date date, Date twoDate){
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		String format1 = format.format(date);
		String format2 = format.format(twoDate);
		return new Integer(format1).equals(new Integer(format2));
	}

	/**
	 * 获取前十二个月份
	 */
	public static Map<String, Map<String, Date>> getBeforeMouth() throws Exception{
        LinkedHashMap<String, Map<String, Date>> bigmap = new LinkedHashMap<>();
        //获取当前月份
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月份");
        SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        for(int i = 1; i <= 12 ; i++){
            Date time = DateUtils.addMonths(date, -i);
            //计算时间端
            String format = sdf.format(time);
            //计算出每个时间端得开始时间和结束时间
            Map<String, Date> stringDateMap = new HashMap<>();
            Calendar cal = new GregorianCalendar();
            cal.setTime(time);
            //获取当月得开始时间
            cal.set(Calendar.DAY_OF_MONTH, 1);
            Date startTime = simpleDateFormat.parse(yyyyMMdd.format(cal.getTime()) + " 00:00:00");
            stringDateMap.put("startDate", startTime);
            //获取当月的结束时间
            cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
            String lastDay = yyyyMMdd.format(cal.getTime());
            Date endDate = simpleDateFormat.parse(lastDay + " 23:59:59");
            stringDateMap.put("endDate", endDate);
            bigmap.put(format,stringDateMap);
        }
        return bigmap;
	}

	/**
	 * 获取前十二个月份名称
	 */
	public static List<String> getBeforeMouthName() throws Exception{
		List<String> stringList =  new ArrayList<>();
		//获取当前月份
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月");
		Date date = new Date();
		for(int i = 1; i <= 12 ; i++){
			Date time = DateUtils.addMonths(date, -i);
			//计算时间端
			String format = sdf.format(time);
			stringList.add(format);
		}
		return stringList;
	}

    /**
     * 获取指定时间所在月份的开始时间和结束时间
     * @return
     * @throws Exception
     */
    public static Map<String, Date> getBeforeMouthByTime(Date date) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月份");
        SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //计算时间端
        String format = sdf.format(date);
        //计算出每个时间端得开始时间和结束时间
        Map<String, Date> stringDateMap = new HashMap<>();
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        //获取当月得开始时间
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date startTime = simpleDateFormat.parse(yyyyMMdd.format(cal.getTime()) + " 00:00:00");
        stringDateMap.put("startDate", startTime);
        //获取当月的结束时间
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        String lastDay = yyyyMMdd.format(cal.getTime());
        Date endDate = simpleDateFormat.parse(lastDay + " 23:59:59");
        stringDateMap.put("endDate", endDate);
        return stringDateMap;
    }

    //计算两个时间相差天数
	public static Long getTimeDiff(Date startTime, Date endTime) {
		Long days = null;
		Calendar c = Calendar.getInstance();
		c.setTime(startTime);
		long l_s = c.getTimeInMillis();
		c.setTime(endTime);
		long l_e = c.getTimeInMillis();
		days = (l_e - l_s) / 86400000;
		return days;
	}

	public static String longdateToString(Long time){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = simpleDateFormat.format(new Date(time));
		return format;
	}

	//计算当天的开始时间
	public static Long getstartTime(Date now) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = simpleDateFormat.format(now);
		String substring = format.substring(0, 10);
		String concat = substring.concat(" 00:00:00");
		Date parse = null;
		try {
			parse = simpleDateFormat.parse(concat);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return parse.getTime() / 1000;
	}

	//计算当天的结束时间
	public static Long getEndTime(Date now)  {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = simpleDateFormat.format(now);
		String endsubstring = format.substring(0, 10);
		String endconcat = endsubstring.concat(" 23:59:59");
		Date parse = null;
		try {
			parse = simpleDateFormat.parse(endconcat);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return parse.getTime() / 1000;
	}

	//计算当天的结束时间
	public static String getnowTime(Date now)  {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = simpleDateFormat.format(now);
		String endsubstring = format.substring(0, 10);
		return endsubstring;
	}


}
