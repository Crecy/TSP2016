package Controll;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Controll {

    public static void main(String[] args) throws Exception
    {
        int yeshu=1;
        String c_mode="";
        int l_money=1;
        int r_money=100000;
        double rate=0.05;
        double r_rate=0.07;
        int l_day=1;
        int r_day=1000;

        String info=captureHtml(yeshu,c_mode,l_money,r_money,rate,r_rate,l_day,r_day);
        System.out.println(info);
    }
    public static String captureHtml(int c_yeshu,String c_mode,int cl_money,int cr_money,double c_rate,double r_rate,int cl_day,int cr_day ) throws Exception {

        int index=0,l,r;
        StringBuilder info=new StringBuilder();
        int yeshu=c_yeshu;
        String mode=c_mode;
        int l_money=cl_money;
        int r_money=cr_money;
        double rate=c_rate;
        double rate_1=r_rate;
        int l_day=cl_day;
        int r_day=cr_day;

        String strURL = "https://list.lu.com/list/transfer-p2p?minMoney="+l_money+"&maxMoney="+r_money+"&minDays="+l_day+"&maxDays="+r_day+"&minRate="+rate+"&maxRate="+r_rate+"&mode=&tradingMode="+mode+"&isCx=&currentPage="+yeshu+"&orderCondition=&isShared=&canRealized=&productCategoryEnum=";
        //System.out.println(strURL);
        URL url = new URL(strURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        InputStreamReader input = new InputStreamReader(httpConn
                .getInputStream(), "utf-8");
        BufferedReader bufReader = new BufferedReader(input);
        String line = "";
        StringBuilder contentBuf = new StringBuilder();
        while ((line = bufReader.readLine()) != null) {
            contentBuf.append(line);
        }
        String buf = contentBuf.toString();
        buf.trim();
        //System.out.println(buf);
        while(true) {

            index = buf.indexOf("class=\"product-name\"",index);

            if(index==-1)
            {
                break;
            }

            l = buf.indexOf(">", index + 23);
            r = buf.indexOf("<", l + 1);
            info.append(buf.substring(l + 1, r));
            info.append("..");
            index = buf.indexOf("预期年化利率", index);
            l = buf.indexOf(">", index + 14);
            r = buf.indexOf("<", l + 1);
            info.append(buf.substring(l + 1, r));
            info.append("..");
            index = buf.indexOf("剩余期限", index);
            l = buf.indexOf("<p>", index);
            r = buf.indexOf("<", l + 3);
            info.append(buf.substring(l + 3, r));
            info.append("..");
            index = buf.indexOf("项目价值", index);
            l = buf.indexOf("\">", index);
            r = buf.indexOf("<", l + 2);
            info.append(buf.substring(l + 2, r));
            info.append("..");

        }

        return info.toString();
    }
}
