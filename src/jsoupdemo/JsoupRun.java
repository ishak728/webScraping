 
package jsoupdemo;

import com.sun.source.tree.Tree;
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//database için
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Timestamp;
import java.sql.Statement;


import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
 

//her şey tamamlandı
//teknosa,n11,vatan ve trendyol da tamamlandı.


public class JsoupRun{
    
   
     
    public static void main(String[] args) throws IOException {
        
         Thread t1;
        t1 = new Thread(){
            @Override
            public void run(){
                
                try {
                    //n11();
                   trendyol();
                    //teknosa();  //bunu eklemedim
                    //vatan();
                } catch (IOException ex) {
                    Logger.getLogger(JsoupRun.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("ishak");
                }
            }
        };
       
        t1.start();
    }
 
 
   public static void addDatabase(String marka,String modelNo,String isletimSistemi,String islemciTipi,String islemciNesli,String ram,String diskBoyutu,String diskTuru,String ekranBoyutu,String puani,String fiyati,String siteIsmi,String link,String image){
            //siteIsmi="22";
            
             
            
       try {
            
            //burda driverimizi clasa tanıtıyoruz
            Class.forName("org.postgresql.Driver");
            
            //deneme adlı veri tabanına bağlanma gerçekleştiriliyor
            Connection connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/Deneme","postgres","546172");
            
          String query="insert into Info(marka, modelno, isletimsistemi, islemcitipi, islemcinesli, ram, diskboyutu, diskturu, ekranboyutu, puani, fiyati, sitef, link, image) values('"+marka+"','"+modelNo+"','"+isletimSistemi+"','"+islemciTipi+"','"+islemciNesli+"','"+ram+"','"+diskBoyutu+"','"+diskTuru+"','"+ekranBoyutu+"','"+puani+"','"+fiyati+"','"+siteIsmi+"','"+link+"','"+image+"')";
            Statement st=connection.createStatement();
            
           st.executeUpdate(query);
            System.out.println("basarili");
            
            
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
             System.out.println("123");
        }
   }

    
    public static int rating(String p) {
        
         
        String n;
        int sayiKacBasamakli=0;
        if(p.length()>10){
            
        
             n=p.substring(6,9);
             
        }
        else{
              
            return 0;
        }
        //width:
        
        //char'a çevriliyor
        char[] dizi=n.toCharArray();
        
        
         
        if(Character.isDigit(dizi[0])){
            sayiKacBasamakli++;
           
        
            if(Character.isDigit(dizi[1])){
                 sayiKacBasamakli++;
                  
             if(Character.isDigit(dizi[2])){
                  sayiKacBasamakli++;
                   
             }
             
             }
               
        }
        else{
            
            return 0;
        }
             
            
        
        
        String k=p.substring(6,6+sayiKacBasamakli);
        
       
       
    
        return Integer.parseInt(k);
    }
    
    
    
    
      public static int ratingVatan(String p){
         
      
         
        String n;
        int sayiKacBasamakli=0;
          
             n=p.substring(6,9);
              
        char[] dizi=n.toCharArray();
         
        
         
        if(Character.isDigit(dizi[0])){
            sayiKacBasamakli++;
            
           
        
            if(Character.isDigit(dizi[1])){
                 sayiKacBasamakli++;
              
                  
             if(Character.isDigit(dizi[2])){
                  sayiKacBasamakli++;
                   
             }
             
             }
               
        }
        else{
            return 0;
        }
            
            
        
        
        String k=p.substring(6,6+sayiKacBasamakli);
           
        int yuzdepuan= Integer.parseInt(k);
       
       
    
        return yuzdepuan*5/100;
    }

      public static String findModelNo(String modelno){
        
          if(modelno.charAt(9)=='/'){
              
              modelno=modelno.substring(0,9);
              return modelno;
          }
          
          
         else if(modelno.charAt(10)=='/'){
              
              modelno=modelno.substring(0,10);
              return modelno;
          }
          
         else if(modelno.charAt(11)=='/'){
              
              modelno=modelno.substring(0,11);
              return modelno;
          }
          
         else if(modelno.charAt(12)=='/'){
              
              modelno=modelno.substring(0,12);
              return modelno;
          }
          
        else  if(modelno.charAt(13)=='/'){
              
              modelno=modelno.substring(0,13);
              return modelno;
          }
          
        else  if(modelno.charAt(14)=='/'){
              
              modelno=modelno.substring(0,14);
              return modelno;
          }
          
        else if(modelno.charAt(15)=='/'){
              
              modelno=modelno.substring(0,15);
              return modelno;
          }
//           else if(modelno.charAt(16)=='/'){      //16'ya kadar geldiğide hata veriyor
//              
//              modelno=modelno.substring(0,16);
//              return modelno;
//          }
//           else if(modelno.charAt(17)=='/'){
//              
//              modelno=modelno.substring(0,18);
//              return modelno;
//          }
//           else if(modelno.charAt(19)=='/'){
//              
//              modelno=modelno.substring(0,19);
//              return modelno;
//          }
//           else if(modelno.charAt(20)=='/'){
//              
//              modelno=modelno.substring(0,20);
//              return modelno;
//          }
//           else if(modelno.charAt(21)=='/'){
//              
//              modelno=modelno.substring(0,21);
//              return modelno;
//          }
//           else if(modelno.charAt(22)=='/'){
//              
//              modelno=modelno.substring(0,22);
//              return modelno;
//          }
//           else if(modelno.charAt(22)=='/'){
//              
//              modelno=modelno.substring(0,22);
//              return modelno;
//          }
//           else if(modelno.charAt(23)=='/'){
//              
//              modelno=modelno.substring(0,23);
//              return modelno;
//          }
          
//          
//modelnonun kısa yoldan bulunmasıdır.devamını sonra yap
//          char[] dizi=modelno.toCharArray();
//          int i=0;
//          for( i=0;;i++){
//              
//              if(dizi[dizi.length-1]=='/'){
//                  break;
//              }
//                     
//          }
          
          
        return "";
      }
      
      
      public static void trendyol() throws IOException{
          
          
                 
        
        
        //Trend yol verileri tamamlandı
        
        ArrayList<String> linkArrayList= new ArrayList<String>();
         ArrayList<String>infoArrayList= new ArrayList<String>();
         ArrayList<String>fiyataArrayList= new ArrayList<String>();
          ArrayList<String>image= new ArrayList<String>();
          ArrayList<String>puanArrayList= new ArrayList<String>();
         
        
        String islemciTipi="",ssdBoyutu="",isletimSistemi="", ram="",islemciNesli="",ekranBoyutu="",hddBoyutu="",hddTuru="",ssdTuru="";
         
          for(int i=1;i<=10;i++){
             
          //veri alınacak siteye bağlanılıyor
          Document d=Jsoup.connect("https://www.trendyol.com/laptop-x-c103108?pi="+i).timeout(000).get();
         
        //listenin tamamı alınıyor
         Elements ele=d.select("div.prdct-cntnr-wrppr");
         
            //burda listenin içinden bir element çekiliyor ve for içinde çekilen element için veriler çekiliyor
            for(Element element:ele.select("div.p-card-wrppr")){
             
                
                String link=" https://www.trendyol.com"+element.select("div.p-card-chldrn-cntnr a").attr("href");
                
                linkArrayList.add(link);
                
                String image_url="https://www.trendyol.com"+element.select("div.p-card-chldrn-cntnr a").select("div.image-container").select("div.p-card-img-wr img").attr("src");
                String ozellik= element.select("div.p-card-chldrn-cntnr a").select("div.image-container").select("div.p-card-img-wr img").attr("alt");
                String fiyat= element.select("div.p-card-chldrn-cntnr a").select("div.product-down").select("div.price-promotion-container").select("div.prc-cntnr").select("div.prc-box-dscntd").text();
                
                
             //   System.out.println(link+"\n"+image_url+"\n"+ozellik+"\n"+fiyat);
       
        
         String p1=element.select("div.p-card-chldrn-cntnr a").select("div.product-down").select("div.ratings-container").select("div.ratings div.star-w:nth-child(1) div.full").attr("style");
         String p2=element.select("div.p-card-chldrn-cntnr a").select("div.product-down").select("div.ratings-container").select("div.ratings div.star-w:nth-child(2) div.full").attr("style");
         String p3=element.select("div.p-card-chldrn-cntnr a").select("div.product-down").select("div.ratings-container").select("div.ratings div.star-w:nth-child(3) div.full").attr("style");
         String p4=element.select("div.p-card-chldrn-cntnr a").select("div.product-down").select("div.ratings-container").select("div.ratings div.star-w:nth-child(4) div.full").attr("style");
         String p5=element.select("div.p-card-chldrn-cntnr a").select("div.product-down").select("div.ratings-container").select("div.ratings div.star-w:nth-child(5) div.full").attr("style");
                
         
         
              double puan=0;
        
              
               puan=puan+ rating(p1);
              puan=puan+ rating(p2);
                puan=puan+rating(p3);
                 puan=puan+rating(p4);
                 puan=puan+ rating(p5);
                 puan=puan/100.0;
                 
    
              
                      String newPuan=Double.toString(puan);
                 
                 
              image.add(image_url);
                    fiyataArrayList.add(fiyat);
                    puanArrayList.add(newPuan);
        
         
             }
            
            
            
           
         
        }

            
            
                      infoArrayList.add("İşlemci Tipi");                      
                      infoArrayList.add("SSD Kapasitesi");
                      infoArrayList.add("İşletim Sistemi");
                      infoArrayList.add("Ram (Sistem Belleği)");
                      infoArrayList.add("İşlemci Nesli");
                      infoArrayList.add("Ekran Boyutu");
                      infoArrayList.add("Hard Disk Kapasitesi");
                      
             //for(int i=0;i<linkArrayList.size();i++){
             for(int i=0;i<linkArrayList.size();i++){
                 Document doc=Jsoup.connect(linkArrayList.get(i)).timeout(000).get();
                 
                 
                 
                 String computerName=doc.select("div.pr-in-cn div h1.pr-new-br a").text();
                   String fiyat=doc.select("div.pr-bx-pr-dsc div:nth-child(2) span").text();
                    String imageString=doc.select("div.product-slide img").attr("src");
                  
                   if(fiyat.compareTo("")==0){
                       fiyat=doc.select("div.product-price-container div.pr-bx-w div.pr-bx-nm span.prc-dsc").text();
                   }
                 
               //  System.out.println("\n\nfiyatt::"+fiyat);
                 
                 
                  Elements ele=doc.select("ul.detail-attr-container");
                  
                  
              
                    for(Element element:ele.select("li.detail-attr-item")){
                        
                        //myString.equalsIgnoreCase(whichInfo)
                        
                        String whichInfo=element.select("span:nth-child(1)").text();
                        
                        if(infoArrayList.get(0).equalsIgnoreCase(whichInfo)){
                              islemciTipi=element.select("span:nth-child(2) b").text();  
                               
                        }
                        else if(infoArrayList.get(1).equalsIgnoreCase(whichInfo)){
                           
                              ssdBoyutu=element.select("span:nth-child(2) b").text();
                              if(ssdTuru.equalsIgnoreCase("SDD Yok")){
                                  ssdTuru="SSD Yok";
                               }
                              else{
                                  ssdTuru="SSD";
                              }
                              
                        }
                         else if(infoArrayList.get(2).equalsIgnoreCase(whichInfo)){
                           
                              isletimSistemi=element.select("span:nth-child(2) b").text();
                               
                        }
                         else if(infoArrayList.get(3).equalsIgnoreCase(whichInfo)){
                            
                              ram=element.select("span:nth-child(2) b").text();
                               
                        }
                         else if(infoArrayList.get(4).equalsIgnoreCase(whichInfo)){
                             
                              islemciNesli=element.select("span:nth-child(2) b").text();
                              
                        }
                         else if(infoArrayList.get(5).equalsIgnoreCase(whichInfo)){
                            
                               ekranBoyutu=element.select("span:nth-child(2) b").text();
                                 
                           
                        }
                         else if(infoArrayList.get(6).equalsIgnoreCase(whichInfo)){
                             
                               hddBoyutu=element.select("span:nth-child(2) b").text();
                               if(hddBoyutu.equalsIgnoreCase("HDD Yok")){
                                   hddTuru="HDD Yok";
                               }
                               else{
                                   hddTuru="HDD";
                               }
                               
                                 
                        }
                       

                      }
                  
                    
                    //hddKapasitesi.compareToIgnoreCase("yok")==0
                    String diskBoyutu="";
                    String diskTuru="";
                    
                    
                    
                    
                     
                             
                         if((hddBoyutu.compareToIgnoreCase("HDD Yok")==0)){
                             diskTuru="SSD";
                             diskBoyutu=ssdBoyutu;
                             
                         }
                         
                         else if((ssdBoyutu.compareToIgnoreCase("SDD Yok")==0)){
                            diskTuru="HDD";
                            diskBoyutu=hddBoyutu;
                         }
                         else{
                             diskTuru="SSD+HDD";
                             diskBoyutu=ssdBoyutu+"-"+hddBoyutu;
                         }
                    
                    
                    
                    
                    
                    
                    
              
                    
                //  System.out.println("işlemcitipi"+islemciTipi+"\n"+"SSdboyut"+ssdBoyutu+"\n"+"SSdturu"+ssdTuru+"\n"+"hddboyut"+hddBoyutu+"\n"+"hddturu"+hddTuru+"\n"+"isletimSistemi"+isletimSistemi+"\n"+"ram"+ram+"\n"+"islemciNesli"+islemciNesli+"\n"+"ekranBoyutu"+ekranBoyutu+"\n");
             
                  
                  addDatabase(computerName,"yokkk",isletimSistemi,islemciTipi,islemciNesli,ram,diskBoyutu,diskTuru,ekranBoyutu,puanArrayList.get(i),fiyat,"4",linkArrayList.get(i),imageString);
                  
//                 System.out.println("computer:"+computerName);
//                  System.out.println("isleti:"+isletimSistemi);
//                   System.out.println("isletip:"+islemciTipi);
//                    System.out.println("islemnesil:"+islemciNesli);
//                     System.out.println("ram:"+ram);
//                      System.out.println("diskboyutr:"+diskBoyutu);
//                       System.out.println("diskturu:"+diskTuru);
//                        System.out.println("ekran boyutu:"+ekranBoyutu);
//                         System.out.println("puan:"+puanArrayList.get(i));
//                          System.out.println("fiyat:"+fiyat);
//                           System.out.println("link:"+linkArrayList.get(i));
//                            System.out.println("image:"+imageString);
                              
                             
                  
             }
              
         
         
      }
      
       public static void n11() throws IOException{
           
       
             
                  
//         //n11 verileri düzgün çalışıyor       


    String islemciTipi="",diskKapasitesi="",isletimSistemi="", ram="",islemciNesli="",ekranBoyutu="",diskTuru="",modeNo="";
         
       
       ArrayList<String>infoArrayList= new ArrayList<String>();
        ArrayList<String>n11linkArrayList= new ArrayList<String>();
         ArrayList<String>fiyataArrayList= new ArrayList<String>();
          ArrayList<String>image= new ArrayList<String>();
          ArrayList<String>computerName= new ArrayList<String>();
        ArrayList<String> linkArrayList= new ArrayList<String>();
        
        
        
        n11linkArrayList.add("https://www.n11.com/bilgisayar/dizustu-bilgisayar?m=Lenovo");
         n11linkArrayList.add("https://www.n11.com/bilgisayar/dizustu-bilgisayar?m=Asus");
          n11linkArrayList.add("https://www.n11.com/bilgisayar/dizustu-bilgisayar?m=HP");
           n11linkArrayList.add("https://www.n11.com/bilgisayar/dizustu-bilgisayar?m=Dell");
            n11linkArrayList.add("https://www.n11.com/bilgisayar/dizustu-bilgisayar?m=Msi");
             n11linkArrayList.add("https://www.n11.com/bilgisayar/dizustu-bilgisayar?m=Monster");
              n11linkArrayList.add("https://www.n11.com/bilgisayar/dizustu-bilgisayar?m=Acer");
               n11linkArrayList.add("https://www.n11.com/bilgisayar/dizustu-bilgisayar?m=Huawei");
                n11linkArrayList.add("https://www.n11.com/bilgisayar/dizustu-bilgisayar?m=Casper");
                 n11linkArrayList.add("https://www.n11.com/bilgisayar/dizustu-bilgisayar?m=Apple");
                 n11linkArrayList.add("https://www.n11.com/bilgisayar/dizustu-bilgisayar?m=Everest");
                 n11linkArrayList.add("https://www.n11.com/bilgisayar/dizustu-bilgisayar?m=Toshiba");
                 n11linkArrayList.add("https://www.n11.com/bilgisayar/dizustu-bilgisayar?m=Game+Garaj");
                  
                 
    
       
       
                      infoArrayList.add("İşletim Sistemi");  //                    
                      infoArrayList.add("Disk Kapasitesi");//
                      infoArrayList.add("İşlemci");//işlemci nesli
                      infoArrayList.add("Bellek Kapasitesi");//ram
                      infoArrayList.add("İşlemci Modeli");//işlemci tipi
                      infoArrayList.add("Ekran Boyutu");//
                      infoArrayList.add("Disk Türü");//
                      infoArrayList.add("Model");//
         
         for(int i=10;i<13;){
             
          Document d=Jsoup.connect(n11linkArrayList.get(i)).timeout(000).get();
         
         Elements ele=d.select("ul.list-ul");
         int m=0;
            for(Element element:ele.select("li.column div.columnContent div.pro")){
                
                    String a=element.select("div.proDetail div.ratingCont span.rating ").toString();
                        
                    String link=element.select("a").attr("href");
                    linkArrayList.add(link);
                    
                    String image_url=element.select("a").select("div.imgHolder img").attr("data-images");
                    String ozellik=element.select("a").select("h3.productName").text();
                    String fiyat=element.select("div.proDetail div.priceContainer div span ins").text();
                    
                    int idx=ozellik.indexOf(" ");
                    String ComputerName=ozellik.substring(0, idx);
                    
                  
                    //System.out.println(ComputerName+"\n"+link+"\n"+image_url+"\n"+ozellik+"\n"+fiyat);
                    computerName.add(ComputerName);
                    image.add(image_url);
                    fiyataArrayList.add(fiyat);
                    
                    m++;
                    if(m==24)
                        break;
                    
             }
//             System.out.println("\n\npart"+i);
         
         i++;
         }
            
       
       
      
      
      
         // for(int i=0;i<1;i++){
        for(int i=0;i<linkArrayList.size();i++){
          Document doc=Jsoup.connect(linkArrayList.get(i)).timeout(000).get();
          
          
         String puan=doc.select("div#unfSummary div.container div.unf-p-summary-left div.ratingCont strong.ratingScore").text();
            System.out.println("puan"+puan);
          
         Elements ele=doc.select("div.unf-prop-context ul.unf-prop-list");
         
            for(Element element:ele.select("li.unf-prop-list-item")){
                if(infoArrayList.contains(element.select("p.unf-prop-list-title").text())){
                    int index=infoArrayList.indexOf(element.select("p.unf-prop-list-title").text());
                    String info=element.select("p.unf-prop-list-prop").text();
                    
                    System.out.println("index:"+index+"\t\tinfo:"+info);
                    if(index==0){
                        isletimSistemi=info;
                    }
                    else if(index==1){
                        diskKapasitesi=info;
                    }
                    else if(index==2){
                        islemciNesli=info;
                    }
                    else if(index==3){
                        ram=info;
                    }
                    else if(index==4){
                        islemciTipi=info;
                    }
                    else if(index==5){
                        ekranBoyutu=info;
                    }
                    else if(index==6){
                        diskTuru=info;
                    }
                    else if(index==7){
                        modeNo=info;
                    }
                    
                }
            }
         
            
             System.out.println("işlemcitipi"+islemciTipi+"\n"+"SSdboyut"+diskKapasitesi+"\n"+"isletimSistemi"+isletimSistemi+"\n"+"ram"+ram+"\n"+"islemciNesli"+islemciNesli+"\n"+"ekranBoyutu"+ekranBoyutu+"\nmodelno:"+modeNo+"\ndiskTuru"+diskTuru+"\n");
     //(String marka,String modelNo,String isletimSistemi,String islemciTipi,String islemciNesli,String ram,String diskBoyutu,String diskTuru,String ekranBoyutu,String puani,String fiyati,String siteIsmi,String link,String image){
            
             
             addDatabase(computerName.get(i),modeNo,isletimSistemi,islemciTipi,islemciNesli,ram,diskKapasitesi,diskTuru,ekranBoyutu,puan,fiyataArrayList.get(i),"1",linkArrayList.get(i),image.get(i));
            
            
        }
         
          
        
        
      }
       public static void vatan() throws IOException{
                   
         
//         Vatan computer verileri model no dahil hepsi tamamlandı
        
 String islemciTipiTekno="",ssdBoyutu="",isletimSistemi="", ram="",islemciNesli="",ekranBoyutu="",diskTuru="";
         
       
       ArrayList<String>infoArrayList= new ArrayList<String>();
         ArrayList<String>fiyataArrayList= new ArrayList<String>();
          ArrayList<String>image= new ArrayList<String>();
          ArrayList<String>puanArrayList= new ArrayList<String>();
          ArrayList<String> linkArrayList= new ArrayList<String>();
       
       
                      infoArrayList.add("İşlemci Teknolojisi");                      
                      infoArrayList.add("Disk Kapasitesi");
                      infoArrayList.add("İşletim Sistemi");
                      infoArrayList.add("Ram (Sistem Belleği)");
                      infoArrayList.add("İşlemci Nesli");
                      infoArrayList.add("Ekran Boyutu");
                      infoArrayList.add("Disk Türü");
                      
         for(int i=1;i<=15;i++){
             
          Document d=Jsoup.connect("https://www.vatanbilgisayar.com/notebook/?page="+i).timeout(000).get();
         
         Elements ele=d.select("div#productsLoad");
         
            for(Element element:ele.select("div.product-list")){
              
            String p=element.select("div.product-list__content div.wrapper-star div.rank-star span").attr("style");
                
             
               String link= " https://www.vatanbilgisayar.com"+element.select("div.product-list__image-safe a").attr("href");
               
               linkArrayList.add(link);
               
                String image_url=element.select("div.product-list__image-safe a img").attr("data-src");
                String ozellik=element.select("div.product-list__image-safe a img").attr("alt");
                String fiyat=element.select("div.product-list__content div.product-list__cost span.product-list__price").text()+" TL";
                int puan=ratingVatan(p);
                String puanString=Integer.toString(puan);
                // System.out.println(link+"\n"+image_url+"\n"+ozellik+"\n"+fiyat+"\n"+puan);
                
                 image.add(image_url);
                 fiyataArrayList.add(fiyat);
                 puanArrayList.add(puanString);
                
         
             }
            System.out.println("\n\nother part"+i+"\n\n");
         
         }
         
         String whichInfo="";
       // for(int i=0;i<1;i++){
         for(int i=0;i<linkArrayList.size();i++){
             
//             Document modelnodoc=Jsoup.connect(linkArrayList.get(i)).timeout(000).get();
//              Elements modelele=modelnodoc.select("div.property-tab");
             
            
              
             
                 Document doc=Jsoup.connect(linkArrayList.get(i)).timeout(000).get();
                 Elements ele=doc.select("div.col-xs-12");
                 
                 String computername=ele.select("div#product-detail div.swiper-container div.wrapper-product-brand a img").attr("alt");
                 System.out.println("+++"+computername);
                 
                 //model no bulunuyor
                 String modelno=ele.select(" div.col-lg-6 div.clearfix div.product-list__product-code").text(); 
                 System.out.println("**********"+modelno);
                     System.out.println("modelno"+findModelNo(modelno));
                     
                     
                 
                  
                 for(Element element:ele.select("div.col-lg-6")){
                     
                   
                     
                    Elements e=element.select("div.product-feature table.product-table");
                   
                    
                    
                    
                     
                     whichInfo=element.select("div.product-feature table.product-table tr:nth-child(1) td:nth-child(1)").text();
                     
                     
                      if(infoArrayList.get(0).equalsIgnoreCase(whichInfo)){
                              islemciTipiTekno=element.select("div.product-feature table.product-table tr:nth-child(1) td:nth-child(2) p:nth-child(1)").text(); 
                               
                               
                        }
                        else if(infoArrayList.get(1).equalsIgnoreCase(whichInfo)){
                            
                              ssdBoyutu=element.select("div.product-feature table.product-table tr:nth-child(1) td:nth-child(2) p:nth-child(1)").text(); 
                              
                              
                        }
                         else if(infoArrayList.get(2).equalsIgnoreCase(whichInfo)){
                            
                              isletimSistemi=element.select("div.product-feature table.product-table tr:nth-child(1) td:nth-child(2) p:nth-child(1)").text(); 
                               
                        }
                         else if(infoArrayList.get(3).equalsIgnoreCase(whichInfo)){
                              
                              ram=element.select("div.product-feature table.product-table tr:nth-child(1) td:nth-child(2) p:nth-child(1)").text(); 
                               
                        }
                         else if(infoArrayList.get(4).equalsIgnoreCase(whichInfo)){
                              
                              islemciNesli=element.select("div.product-feature table.product-table tr:nth-child(1) td:nth-child(2) p:nth-child(1)").text(); 
                              
                        }
                         else if(infoArrayList.get(5).equalsIgnoreCase(whichInfo)){
                              
                               ekranBoyutu=element.select("div.product-feature table.product-table tr:nth-child(1) td:nth-child(2) p:nth-child(1)").text(); 
                                 
                           
                        }
                       else if(infoArrayList.get(6).equalsIgnoreCase(whichInfo)){
                              
                               diskTuru=element.select("div.product-feature table.product-table tr:nth-child(1) td:nth-child(2) p:nth-child(1)").text(); 
                                 
                           
                        }
                      
                      
                      
                      
                      
                     
                   whichInfo=element.select("div.product-feature table.product-table tr:nth-child(2) td:nth-child(1)").text();
                      if(infoArrayList.get(0).equalsIgnoreCase(whichInfo)){
                              islemciTipiTekno=element.select("div.product-feature table.product-table tr:nth-child(2) td:nth-child(2) p:nth-child(1)").text(); 
                               
                        }
                        else if(infoArrayList.get(1).equalsIgnoreCase(whichInfo)){
                           
                              ssdBoyutu=element.select("div.product-feature table.product-table tr:nth-child(2) td:nth-child(2) p:nth-child(1)").text(); 
                              
                              
                        }
                         else if(infoArrayList.get(2).equalsIgnoreCase(whichInfo)){
                           
                              isletimSistemi=element.select("div.product-feature table.product-table tr:nth-child(2) td:nth-child(2) p:nth-child(1)").text(); 
                               
                        }
                         else if(infoArrayList.get(3).equalsIgnoreCase(whichInfo)){
                            
                              ram=element.select("div.product-feature table.product-table tr:nth-child(2) td:nth-child(2) p:nth-child(1)").text(); 
                               
                        }
                         else if(infoArrayList.get(4).equalsIgnoreCase(whichInfo)){
                             
                              islemciNesli=element.select("div.product-feature table.product-table tr:nth-child(2) td:nth-child(2) p:nth-child(1)").text(); 
                              
                        }
                         else if(infoArrayList.get(5).equalsIgnoreCase(whichInfo)){
                            
                               ekranBoyutu=element.select("div.product-feature table.product-table tr:nth-child(2) td:nth-child(2) p:nth-child(1)").text(); 
                                 
                           
                        }
                       else if(infoArrayList.get(6).equalsIgnoreCase(whichInfo)){
                            
                               diskTuru=element.select("div.product-feature table.product-table tr:nth-child(2) td:nth-child(2) p:nth-child(1)").text(); 
                                 
                           
                        }
                      
                     
                    whichInfo=element.select("div.product-feature table.product-table tr:nth-child(3) td:nth-child(1)").text();
                      if(infoArrayList.get(0).equalsIgnoreCase(whichInfo)){
                              islemciTipiTekno=element.select("div.product-feature table.product-table tr:nth-child(3) td:nth-child(2) p:nth-child(1)").text(); 
                               
                        }
                        else if(infoArrayList.get(1).equalsIgnoreCase(whichInfo)){
                           
                              ssdBoyutu=element.select("div.product-feature table.product-table tr:nth-child(3) td:nth-child(2) p:nth-child(1)").text(); 
                              
                              
                        }
                         else if(infoArrayList.get(2).equalsIgnoreCase(whichInfo)){
                           
                              isletimSistemi=element.select("div.product-feature table.product-table tr:nth-child(3) td:nth-child(2) p:nth-child(1)").text(); 
                               
                        }
                         else if(infoArrayList.get(3).equalsIgnoreCase(whichInfo)){
                            
                              ram=element.select("div.product-feature table.product-table tr:nth-child(3) td:nth-child(2) p:nth-child(1)").text(); 
                               
                        }
                         else if(infoArrayList.get(4).equalsIgnoreCase(whichInfo)){
                             
                              islemciNesli=element.select("div.product-feature table.product-table tr:nth-child(3) td:nth-child(2) p:nth-child(1)").text(); 
                              
                        }
                         else if(infoArrayList.get(5).equalsIgnoreCase(whichInfo)){
                            
                               ekranBoyutu=element.select("div.product-feature table.product-table tr:nth-child(3) td:nth-child(2) p:nth-child(1)").text(); 
                                 
                           
                        }
                       else if(infoArrayList.get(6).equalsIgnoreCase(whichInfo)){
                            
                               diskTuru=element.select("div.product-feature table.product-table tr:nth-child(3) td:nth-child(2) p:nth-child(1)").text(); 
                                 
                           
                        }
                      
                     whichInfo=element.select("div.product-feature table.product-table tr:nth-child(4) td:nth-child(1)").text();
                      
                      if(infoArrayList.get(0).equalsIgnoreCase(whichInfo)){
                              islemciTipiTekno=element.select("div.product-feature table.product-table tr:nth-child(4) td:nth-child(2) p:nth-child(1)").text(); 
                               
                        }
                        else if(infoArrayList.get(1).equalsIgnoreCase(whichInfo)){
                           
                              ssdBoyutu=element.select("div.product-feature table.product-table tr:nth-child(4) td:nth-child(2) p:nth-child(1)").text(); 
                              
                              
                        }
                         else if(infoArrayList.get(2).equalsIgnoreCase(whichInfo)){
                           
                              isletimSistemi=element.select("div.product-feature table.product-table tr:nth-child(4) td:nth-child(2) p:nth-child(1)").text(); 
                               
                        }
                         else if(infoArrayList.get(3).equalsIgnoreCase(whichInfo)){
                            
                              ram=element.select("div.product-feature table.product-table tr:nth-child(4) td:nth-child(2) p:nth-child(1)").text(); 
                               
                        }
                         else if(infoArrayList.get(4).equalsIgnoreCase(whichInfo)){
                             
                              islemciNesli=element.select("div.product-feature table.product-table tr:nth-child(4) td:nth-child(2) p:nth-child(1)").text(); 
                              
                        }
                         else if(infoArrayList.get(5).equalsIgnoreCase(whichInfo)){
                            
                               ekranBoyutu=element.select("div.product-feature table.product-table tr:nth-child(4) td:nth-child(2) p:nth-child(1)").text(); 
                                 
                           
                        }
                       else if(infoArrayList.get(6).equalsIgnoreCase(whichInfo)){
                            
                               diskTuru=element.select("div.product-feature table.product-table tr:nth-child(4) td:nth-child(2) p:nth-child(1)").text(); 
                                 
                           
                        }
                      
                     
                     whichInfo=element.select("div.product-feature table.product-table tr:nth-child(5) td:nth-child(1)").text();
                      if(infoArrayList.get(0).equalsIgnoreCase(whichInfo)){
                              islemciTipiTekno=element.select("div.product-feature table.product-table tr:nth-child(5) td:nth-child(2) p:nth-child(1)").text(); 
                               
                        }
                        else if(infoArrayList.get(1).equalsIgnoreCase(whichInfo)){
                           
                              ssdBoyutu=element.select("div.product-feature table.product-table tr:nth-child(5) td:nth-child(2) p:nth-child(1)").text(); 
                              
                              
                        }
                         else if(infoArrayList.get(2).equalsIgnoreCase(whichInfo)){
                           
                              isletimSistemi=element.select("div.product-feature table.product-table tr:nth-child(5) td:nth-child(2) p:nth-child(1)").text(); 
                               
                        }
                         else if(infoArrayList.get(3).equalsIgnoreCase(whichInfo)){
                            
                              ram=element.select("div.product-feature table.product-table tr:nth-child(5) td:nth-child(2) p:nth-child(1)").text(); 
                               
                        }
                         else if(infoArrayList.get(4).equalsIgnoreCase(whichInfo)){
                             
                              islemciNesli=element.select("div.product-feature table.product-table tr:nth-child(5) td:nth-child(2) p:nth-child(1)").text(); 
                              
                        }
                         else if(infoArrayList.get(5).equalsIgnoreCase(whichInfo)){
                            
                               ekranBoyutu=element.select("div.product-feature table.product-table tr:nth-child(5) td:nth-child(2) p:nth-child(1)").text(); 
                                 
                           
                        }
                       else if(infoArrayList.get(6).equalsIgnoreCase(whichInfo)){
                            
                               diskTuru=element.select("div.product-feature table.product-table tr:nth-child(5) td:nth-child(2) p:nth-child(1)").text(); 
                                 
                           
                        }
                      
                     
                    whichInfo=element.select("div.product-feature table.product-table tr:nth-child(6) td:nth-child(1)").text();
                      if(infoArrayList.get(0).equalsIgnoreCase(whichInfo)){
                              islemciTipiTekno=element.select("div.product-feature table.product-table tr:nth-child(6) td:nth-child(2) p:nth-child(1)").text(); 
                               
                        }
                        else if(infoArrayList.get(1).equalsIgnoreCase(whichInfo)){
                           
                              ssdBoyutu=element.select("div.product-feature table.product-table tr:nth-child(6) td:nth-child(2) p:nth-child(1)").text(); 
                              
                              
                        }
                         else if(infoArrayList.get(2).equalsIgnoreCase(whichInfo)){
                           
                              isletimSistemi=element.select("div.product-feature table.product-table tr:nth-child(6) td:nth-child(2) p:nth-child(1)").text(); 
                               
                        }
                         else if(infoArrayList.get(3).equalsIgnoreCase(whichInfo)){
                            
                              ram=element.select("div.product-feature table.product-table tr:nth-child(6) td:nth-child(2) p:nth-child(1)").text(); 
                               
                        }
                         else if(infoArrayList.get(4).equalsIgnoreCase(whichInfo)){
                             
                              islemciNesli=element.select("div.product-feature table.product-table tr:nth-child(6) td:nth-child(2) p:nth-child(1)").text(); 
                              
                        }
                         else if(infoArrayList.get(5).equalsIgnoreCase(whichInfo)){
                            
                               ekranBoyutu=element.select("div.product-feature table.product-table tr:nth-child(6) td:nth-child(2) p:nth-child(1)").text(); 
                                 
                           
                        }
                       else if(infoArrayList.get(6).equalsIgnoreCase(whichInfo)){
                            
                               diskTuru=element.select("div.product-feature table.product-table tr:nth-child(6) td:nth-child(2) p:nth-child(1)").text(); 
                                 
                           
                        }
                      
                     
                    whichInfo=element.select("div.product-feature table.product-table tr:nth-child(7) td:nth-child(1)").text();
                      if(infoArrayList.get(0).equalsIgnoreCase(whichInfo)){
                              islemciTipiTekno=element.select("div.product-feature table.product-table tr:nth-child(7) td:nth-child(2) p:nth-child(1)").text(); 
                               
                        }
                        else if(infoArrayList.get(1).equalsIgnoreCase(whichInfo)){
                           
                              ssdBoyutu=element.select("div.product-feature table.product-table tr:nth-child(7) td:nth-child(2) p:nth-child(1)").text(); 
                              
                              
                        }
                         else if(infoArrayList.get(2).equalsIgnoreCase(whichInfo)){
                           
                              isletimSistemi=element.select("div.product-feature table.product-table tr:nth-child(7) td:nth-child(2) p:nth-child(1)").text(); 
                               
                        }
                         else if(infoArrayList.get(3).equalsIgnoreCase(whichInfo)){
                            
                              ram=element.select("div.product-feature table.product-table tr:nth-child(7) td:nth-child(2) p:nth-child(1)").text(); 
                               
                        }
                         else if(infoArrayList.get(4).equalsIgnoreCase(whichInfo)){
                             
                              islemciNesli=element.select("div.product-feature table.product-table tr:nth-child(7) td:nth-child(2) p:nth-child(1)").text(); 
                              
                        }
                         else if(infoArrayList.get(5).equalsIgnoreCase(whichInfo)){
                            
                               ekranBoyutu=element.select("div.product-feature table.product-table tr:nth-child(7) td:nth-child(2) p:nth-child(1)").text(); 
                                 
                           
                        }
                       else if(infoArrayList.get(6).equalsIgnoreCase(whichInfo)){
                            
                               diskTuru=element.select("div.product-feature table.product-table tr:nth-child(7) td:nth-child(2) p:nth-child(1)").text(); 
                                 
                           
                        }
                      
                     
                    whichInfo=element.select("div.product-feature table.product-table tr:nth-child(8) td:nth-child(1)").text();
                      if(infoArrayList.get(0).equalsIgnoreCase(whichInfo)){
                              islemciTipiTekno=element.select("div.product-feature table.product-table tr:nth-child(8) td:nth-child(2) p:nth-child(1)").text(); 
                               
                        }
                        else if(infoArrayList.get(1).equalsIgnoreCase(whichInfo)){
                           
                              ssdBoyutu=element.select("div.product-feature table.product-table tr:nth-child(8) td:nth-child(2) p:nth-child(1)").text(); 
                              
                              
                        }
                         else if(infoArrayList.get(2).equalsIgnoreCase(whichInfo)){
                           
                              isletimSistemi=element.select("div.product-feature table.product-table tr:nth-child(8) td:nth-child(2) p:nth-child(1)").text(); 
                               
                        }
                         else if(infoArrayList.get(3).equalsIgnoreCase(whichInfo)){
                            
                              ram=element.select("div.product-feature table.product-table tr:nth-child(8) td:nth-child(2) p:nth-child(1)").text(); 
                               
                        }
                         else if(infoArrayList.get(4).equalsIgnoreCase(whichInfo)){
                             
                              islemciNesli=element.select("div.product-feature table.product-table tr:nth-child(8) td:nth-child(2) p:nth-child(1)").text(); 
                              
                        }
                         else if(infoArrayList.get(5).equalsIgnoreCase(whichInfo)){
                            
                               ekranBoyutu=element.select("div.product-feature table.product-table tr:nth-child(8) td:nth-child(2) p:nth-child(1)").text(); 
                                 
                           
                        }
                       else if(infoArrayList.get(6).equalsIgnoreCase(whichInfo)){
                            
                               diskTuru=element.select("div.product-feature table.product-table tr:nth-child(8) td:nth-child(2) p:nth-child(1)").text(); 
                                 
                           
                        }
                      
                     
                   whichInfo=element.select("div.product-feature table.product-table tr:nth-child(9) td:nth-child(1)").text();
                      if(infoArrayList.get(0).equalsIgnoreCase(whichInfo)){
                              islemciTipiTekno=element.select("div.product-feature table.product-table tr:nth-child(9) td:nth-child(2) p:nth-child(1)").text(); 
                               
                        }
                        else if(infoArrayList.get(1).equalsIgnoreCase(whichInfo)){
                           
                              ssdBoyutu=element.select("div.product-feature table.product-table tr:nth-child(9) td:nth-child(2) p:nth-child(1)").text(); 
                              
                              
                        }
                         else if(infoArrayList.get(2).equalsIgnoreCase(whichInfo)){
                           
                              isletimSistemi=element.select("div.product-feature table.product-table tr:nth-child(9) td:nth-child(2) p:nth-child(1)").text(); 
                               
                        }
                         else if(infoArrayList.get(3).equalsIgnoreCase(whichInfo)){
                            
                              ram=element.select("div.product-feature table.product-table tr:nth-child(9) td:nth-child(2) p:nth-child(1)").text(); 
                               
                        }
                         else if(infoArrayList.get(4).equalsIgnoreCase(whichInfo)){
                             
                              islemciNesli=element.select("div.product-feature table.product-table tr:nth-child(9) td:nth-child(2) p:nth-child(1)").text(); 
                              
                        }
                         else if(infoArrayList.get(5).equalsIgnoreCase(whichInfo)){
                            
                               ekranBoyutu=element.select("div.product-feature table.product-table tr:nth-child(9) td:nth-child(2) p:nth-child(1)").text(); 
                                 
                           
                        }
                       else if(infoArrayList.get(6).equalsIgnoreCase(whichInfo)){
                            
                               diskTuru=element.select("div.product-feature table.product-table tr:nth-child(9) td:nth-child(2) p:nth-child(1)").text(); 
                                 
                           
                        }
                      
                     whichInfo=element.select("div.product-feature table.product-table tr:nth-child(10) td:nth-child(1)").text();
                      if(infoArrayList.get(0).equalsIgnoreCase(whichInfo)){
                              islemciTipiTekno=element.select("div.product-feature table.product-table tr td:nth-child(2) p:nth-child(1)").text(); 
                               
                        }
                        else if(infoArrayList.get(1).equalsIgnoreCase(whichInfo)){
                           
                              ssdBoyutu=element.select("div.product-feature table.product-table tr:nth-child(10) td:nth-child(2) p:nth-child(1)").text(); 
                              
                              
                        }
                         else if(infoArrayList.get(2).equalsIgnoreCase(whichInfo)){
                           
                              isletimSistemi=element.select("div.product-feature table.product-table tr:nth-child(10) td:nth-child(2) p:nth-child(1)").text(); 
                               
                        }
                         else if(infoArrayList.get(3).equalsIgnoreCase(whichInfo)){
                            
                              ram=element.select("div.product-feature table.product-table tr:nth-child(10) td:nth-child(2) p:nth-child(1)").text(); 
                               
                        }
                         else if(infoArrayList.get(4).equalsIgnoreCase(whichInfo)){
                             
                              islemciNesli=element.select("div.product-feature table.product-table tr:nth-child(10) td:nth-child(2) p:nth-child(1)").text(); 
                              
                        }
                         else if(infoArrayList.get(5).equalsIgnoreCase(whichInfo)){
                            
                               ekranBoyutu=element.select("div.product-feature table.product-table tr:nth-child(10) td:nth-child(2) p:nth-child(1)").text(); 
                                 
                           
                        }
                       else if(infoArrayList.get(6).equalsIgnoreCase(whichInfo)){
                            
                               diskTuru=element.select("div.product-feature table.product-table tr:nth-child(10) td:nth-child(2) p:nth-child(1)").text(); 
                                 
                           
                        }
                      
                     
                     
                 }
                  System.out.println("işlemcitipiTekno"+islemciTipiTekno+"\n"+"SSdboyut"+ssdBoyutu+"\n"+"SSdturu"+diskTuru+"\n"+"isletimSistemi"+isletimSistemi+"\n"+"ram"+ram+"\n"+"islemciNesli"+islemciNesli+"\n"+"ekranBoyutu"+ekranBoyutu+"\n");
//             
                //vatan sitesi için 2 sayısını gönderdim

addDatabase(computername,modelno,isletimSistemi,islemciTipiTekno,islemciNesli,ram,ssdBoyutu,diskTuru,ekranBoyutu,puanArrayList.get(i),fiyataArrayList.get(i),"2",linkArrayList.get(i),image.get(i));
                 
         }
         
         
         
         

          
      }
      
       //veri tabanı tablosuna hdd ve ssd için ayrı column yap
       public static void teknosa() throws IOException{
          
           
           

         //teknosa modelno dahil herşey tamam
         
           
       ArrayList<String>infoArrayList= new ArrayList<String>();
       ArrayList<String> linkArrayList= new ArrayList<String>();
        ArrayList<String>fiyataArrayList= new ArrayList<String>();
          ArrayList<String>image= new ArrayList<String>();
          ArrayList<String>puanArrayList= new ArrayList<String>();
       
         for(int i=1;i<=16;i++){
             
          Document d=Jsoup.connect("https://www.teknosa.com/laptop-notebook-c-116004?s=%3Arelevance&page="+i).timeout(000).get();
         
         Elements ele=d.select("div.products");
         
            for(Element element:ele.select("div#product-item")){
             
               
                String rating="";
                rating= d.select("div.listing-page-bv div a#273b342f-686d-4dcd-8817-30e517ed21e3 div.bv_averageRating_component_container div.bv_text").text();
               
                if(rating.compareTo("")==0){
                    rating="0";
                }
                
                
            String link= "https://www.teknosa.com"+element.select("a.prd-link").attr("href");
           // System.out.println("link:: https://www.teknosa.com"+element.select("a.prd-link").attr("href") ); 
            linkArrayList.add(link);
            
//            //image_url'nin bazıları alınamıyor nedense onunla aynı olan ozellikleri alabiliyor
//          System.out.println("image_url::"+element.select("div.prd-inner div.prd-media figure.responsive img").attr("src") );
//          System.out.println("ozellik::"+element.select("div.prd-inner div.prd-media figure.responsive img").attr("alt") );
//           System.out.println("fiyat::"+element.select("div.prd-inner div.prd-body div.prd-block2 div.prd-amount div.prd-prices div.prd-prc2 span").text());
//

           String imagee=element.select("div.prd-inner div.prd-media figure.responsive img").attr("src");
           String fiyat=element.select("div.prd-inner div.prd-body div.prd-block2 div.prd-amount div.prd-prices div.prd-prc2 span").text();
 
            //System.out.println("ratingBar::"+element.select("div.prd-inner div.prd-body div.listing-page-bv div a.bv_main_container ").attr("aria-label"));
        
         puanArrayList.add(rating);
         fiyataArrayList.add(fiyat);
         image.add(imagee);
         
             }
           System.out.println("\n\nother part"+i+"\n\n");
         
         }
         
         
                String islemci="",ssdKapasitesi="",isletimSistemi="", ram="",islemciNesli="",ekranBoyutu="", modelKodu="",hddKapasitesi="",diskTuru="";
                
                      infoArrayList.add("İşlemci"); //işlemci tipi i7                     
                      infoArrayList.add("SSD Kapasitesi");//disk turune ssd diye yaz
                      infoArrayList.add("İşletim Sistemi Yazılımı");
                      infoArrayList.add("Ram");
                      infoArrayList.add("İşlemci Nesli");//
                      infoArrayList.add("Ekran Boyutu");//
                      infoArrayList.add("HDD Kapasitesi");
                      infoArrayList.add("Model Kodu");//

                       // for(int i=0;i<1;i++){
                       for(int i=0;i<linkArrayList.size();i++){
             
                           Document d=Jsoup.connect(linkArrayList.get(i)).timeout(000).get();
                           Elements ele=d.select("div#pdp-technical div.pdp-acc-body div.ptf-item div.ptf-body");
                           String imageString=d.select("div.swiper-slide figure.responsive img").attr("data-srcset");
                           System.out.println("\n\niamage:"+imageString);
                           String computerName=d.select("div#pdp-main div.pdp-block2 div.pdp-base h1.pdp-title b").text();
                            System.out.println("comoutername:"+computerName);
                            String whichInfo="";
                             for(Element element:ele.select("table")){
                                 whichInfo= element.select("tbody tr:nth-child(1) th:nth-child(1)").text();
                                   
                                 if(infoArrayList.contains(whichInfo)){
                                     int index=infoArrayList.indexOf(whichInfo);
                                     
                                     
                                     if(index==0){
                                         islemci=element.select("tbody tr:nth-child(2) td:nth-child(1)").text();
                                     }
                                    else if(index==1){
                                         ssdKapasitesi=element.select("tbody tr:nth-child(2) td:nth-child(1)").text();
                                         
                                     }
                                     else if(index==2){
                                         isletimSistemi=element.select("tbody tr:nth-child(2) td:nth-child(1)").text();
                                     }
                                    else  if(index==3){
                                         ram=element.select("tbody tr:nth-child(2) td:nth-child(1)").text();
                                     }
                                     else if(index==4){
                                         islemciNesli=element.select("tbody tr:nth-child(2) td:nth-child(1)").text(); 
                                     }
                                     else if(index==5){
                                         ekranBoyutu=element.select("tbody tr:nth-child(2) td:nth-child(1)").text();  
                                     }
                                     
                                     else if(index==6){
                                         hddKapasitesi=element.select("tbody tr:nth-child(2) td:nth-child(1)").text();
                                     }
                                     else if(index==7){
                                         modelKodu=element.select("tbody tr:nth-child(2) td:nth-child(1)").text();  
                                     }
                                     
                                 }
                                 
                                 whichInfo= element.select("tbody tr:nth-child(1) th:nth-child(2)").text();
                                  
                                 if(infoArrayList.contains(whichInfo)){
                                     int index=infoArrayList.indexOf(whichInfo);
                                      
                                     if(index==0){
                                         islemci=element.select("tbody tr:nth-child(2) td:nth-child(2)").text();
                                     }
                                    else if(index==1){
                                         ssdKapasitesi=element.select("tbody tr:nth-child(2) td:nth-child(2)").text();
                                     }
                                     else if(index==2){
                                         isletimSistemi=element.select("tbody tr:nth-child(2) td:nth-child(2)").text();
                                     }
                                     else if(index==3){
                                       ram=element.select("tbody tr:nth-child(2) td:nth-child(2)").text();
                                     }
                                     else if(index==4){
                                          islemciNesli=element.select("tbody tr:nth-child(2) td:nth-child(2)").text(); 
                                     }
                                     else if(index==5){
                                         ekranBoyutu=element.select("tbody tr:nth-child(2) td:nth-child(2)").text();  
                                     }
                                     
                                     else if(index==6){
                                         hddKapasitesi=element.select("tbody tr:nth-child(2) td:nth-child(2)").text();
                                     }
                                     else if(index==7){
                                         modelKodu=element.select("tbody tr:nth-child(2) td:nth-child(2)").text(); 
                                     }
                                     
                                 }
                                 
                                  whichInfo= element.select("tbody tr:nth-child(1) th:nth-child(3)").text();
                                    
                                 if(infoArrayList.contains(whichInfo)){
                                     int index=infoArrayList.indexOf(whichInfo);
                                    
                                     if(index==0){
                                         islemci=element.select("tbody tr:nth-child(2) td:nth-child(3)").text();
                                     }
                                    else if(index==1){
                                         ssdKapasitesi=element.select("tbody tr:nth-child(2) td:nth-child(3)").text();
                                     }
                                     else if(index==2){
                                         System.out.println("ooooooooooooooooooooooooooooooooooooooo");
                                        isletimSistemi=element.select("tbody tr:nth-child(2) td:nth-child(3)").text();
                                     }
                                    else  if(index==3){
                                         ram=element.select("tbody tr:nth-child(2) td:nth-child(3)").text();
                                     }
                                     else if(index==4){
                                         islemciNesli=element.select("tbody tr:nth-child(2) td:nth-child(3)").text(); 
                                     }
                                     else if(index==5){
                                         ekranBoyutu=element.select("tbody tr:nth-child(2) td:nth-child(3)").text(); 
                                     }
                                     
                                     else if(index==6){
                                         hddKapasitesi=element.select("tbody tr:nth-child(2) td:nth-child(3)").text();
                                     }
                                     else if(index==7){
                                        modelKodu=element.select("tbody tr:nth-child(2) td:nth-child(3)").text();  
                                     }
                                     
                                 }
                                 
                                  whichInfo= element.select("tbody tr:nth-child(1) th:nth-child(4)").text();
                                    
                                 if(infoArrayList.contains(whichInfo)){
                                     int index=infoArrayList.indexOf(whichInfo);
                                    
                                     if(index==0){
                                         islemci=element.select("tbody tr:nth-child(2) td:nth-child(4)").text();
                                     }
                                    else if(index==1){
                                         ssdKapasitesi=element.select("tbody tr:nth-child(2) td:nth-child(4)").text();
                                     }
                                   else   if(index==2){
                                         isletimSistemi=element.select("tbody tr:nth-child(2) td:nth-child(4)").text();
                                     }
                                    else  if(index==3){
                                        ram=element.select("tbody tr:nth-child(2) td:nth-child(4)").text();
                                     }
                                     else if(index==4){
                                          islemciNesli=element.select("tbody tr:nth-child(2) td:nth-child(4)").text();  
                                     }
                                     else if(index==5){
                                        ekranBoyutu=element.select("tbody tr:nth-child(2) td:nth-child(4)").text();  
                                     }
                                     
                                     else if(index==6){
                                         hddKapasitesi=element.select("tbody tr:nth-child(2) td:nth-child(4)").text();
                                     }
                                     else if(index==7){
                                        modelKodu=element.select("tbody tr:nth-child(2) td:nth-child(4)").text();  
                                     }
                                     
                                 }
                                 
                                  whichInfo= element.select("tbody tr:nth-child(1) th:nth-child(5)").text();
                                    
                                 if(infoArrayList.contains(whichInfo)){
                                     int index=infoArrayList.indexOf(whichInfo);
                                     
                                     if(index==0){
                                         islemci=element.select("tbody tr:nth-child(2) td:nth-child(5)").text();
                                     }
                                    else if(index==1){
                                        ssdKapasitesi=element.select("tbody tr:nth-child(2) td:nth-child(5)").text();
                                     }
                                    else  if(index==2){
                                        isletimSistemi=element.select("tbody tr:nth-child(2) td:nth-child(5)").text();
                                     }
                                    else  if(index==3){
                                      ram=element.select("tbody tr:nth-child(2) td:nth-child(5)").text();
                                     }
                                     else if(index==4){
                                         islemciNesli=element.select("tbody tr:nth-child(2) td:nth-child(5)").text(); 
                                         System.out.println("ishakkkkkk");
                                     }
                                     else if(index==5){
                                         ekranBoyutu=element.select("tbody tr:nth-child(2) td:nth-child(5)").text();  
                                     }
                                     
                                     else if(index==6){
                                         hddKapasitesi=element.select("tbody tr:nth-child(2) td:nth-child(5)").text();
                                     }
                                     else if(index==7){
                                         modelKodu=element.select("tbody tr:nth-child(2) td:nth-child(5)").text(); 
                                     }
                                     
                                 }
                                 
                                 
                                  whichInfo= element.select("tbody tr:nth-child(1) th:nth-child(6)").text();
                                  
                                 if(infoArrayList.contains(whichInfo)){
                                     int index=infoArrayList.indexOf(whichInfo);
                                
                                     if(index==0){
                                         islemci=element.select("tbody tr:nth-child(2) td:nth-child(6)").text();
                                     }
                                    else if(index==1){
                                         ssdKapasitesi=element.select("tbody tr:nth-child(2) td:nth-child(6)").text();
                                     }
                                    else  if(index==2){
                                         isletimSistemi=element.select("tbody tr:nth-child(2) td:nth-child(6)").text();
                                     }
                                    else  if(index==3){
                                         ram=element.select("tbody tr:nth-child(2) td:nth-child(6)").text();
                                     }
                                     else if(index==4){
                                         islemciNesli=element.select("tbody tr:nth-child(2) td:nth-child(6)").text();  
                                     }
                                     else if(index==5){
                                         ekranBoyutu=element.select("tbody tr:nth-child(2) td:nth-child(6)").text();  
                                     }
                                     
                                     else if(index==6){
                                         hddKapasitesi=element.select("tbody tr:nth-child(2) td:nth-child(6)").text();
                                     }
                                     else if(index==7){
                                         modelKodu=element.select("tbody tr:nth-child(2) td:nth-child(6)").text(); 
                                     }
                                     
                                 }
                                 
                                 
                                 
                                  whichInfo= element.select("tbody tr:nth-child(1) th:nth-child(7)").text();
                                      
                                 if(infoArrayList.contains(whichInfo)){
                                     int index=infoArrayList.indexOf(whichInfo);
                                   
                                     if(index==0){
                                         islemci=element.select("tbody tr:nth-child(2) td:nth-child(7)").text();
                                     }
                                    else if(index==1){
                                         ssdKapasitesi=element.select("tbody tr:nth-child(2) td:nth-child(7)").text();
                                     }
                                   else   if(index==2){
                                         isletimSistemi=element.select("tbody tr:nth-child(2) td:nth-child(7)").text();
                                     }
                                    else  if(index==3){
                                         ram=element.select("tbody tr:nth-child(2) td:nth-child(7)").text();
                                     }
                                     else if(index==4){
                                         islemciNesli=element.select("tbody tr:nth-child(2) td:nth-child(7)").text(); 
                                     }
                                     else if(index==5){
                                         ekranBoyutu=element.select("tbody tr:nth-child(2) td:nth-child(7)").text();  
                                     }
                                     
                                     else if(index==6){
                                         hddKapasitesi=element.select("tbody tr:nth-child(2) td:nth-child(7)").text();
                                     }
                                     else if(index==7){
                                         modelKodu=element.select("tbody tr:nth-child(2) td:nth-child(7)").text();  
                                     }
                                     
                                 }
                                 
                                 
                                 
                             }
                           
                             
                            
                             char c=ssdKapasitesi.charAt(0);
                             char m=hddKapasitesi.charAt(0);
                             
                             
                         if((hddKapasitesi.compareToIgnoreCase("yok")==0)){
                             diskTuru="SSD";
                             
                         }
                         
                         else if((ssdKapasitesi.compareToIgnoreCase("yok")==0)){
                            diskTuru="HDD";
                            ssdKapasitesi=hddKapasitesi;
                         }
                         else{
                             diskTuru="SSD+HDD";
                             ssdKapasitesi=ssdKapasitesi+hddKapasitesi;
                         }
                         
                            //NOT:ssd kapasitesi disk kapasitesi olarak yazdım.
                           System.out.println("işlemcitipiTekno"+islemci+"\n"+"SSdboyut"+ssdKapasitesi+"\n"+"isletimSistemi"+isletimSistemi+"\n"+"ram"+ram+"\n"+"islemciNesli"+islemciNesli+"\n"+"ekranBoyutu"+ekranBoyutu+"\nhddkapasite:"+hddKapasitesi+"\nmodelkodu:"+modelKodu+"\ndiskTuru"+diskTuru+"\n");
            
                           
               
                        addDatabase(computerName,modelKodu,isletimSistemi,islemci,islemciNesli,ram,ssdKapasitesi,diskTuru,ekranBoyutu,puanArrayList.get(i),fiyataArrayList.get(i),"3",linkArrayList.get(i),imageString);
                           
                       }
                        



      }

   
      
   
}

