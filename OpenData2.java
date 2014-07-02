import java.io.*;
import java.util.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.*;
import java.lang.*;
import java.net.URL;
import java.net.SocketTimeoutException;
import org.json.*;



public class OpenData2 {

	private  URL url = null;
	//String[] ALL_Courses_Names={"EE_Courses","SS_Courses","MS_Courses","EN_Courses","FS_Courses","LS_Courses","GE_Courses","OE_Courses"};
	String[] EE_Courses={"E2","F7","N2","P7","P9","Q1","Q3","Q5"};
	String[] SS_Courses={"D2","D4","D5","D8","U1","U2","U3","U5","U6","U7"};
	String[] MD_Courses={"I2","I3","I5","I6","I7","I8","T2","T3","T6","T7","S1","S2","S3","S4","S5","S6","S7","S8","S9"
						 ,"SA","T1","T4","T8","T9","TA","TB","TC"};
	String[] MS_Courses={"H1","H2","H3","H4","H5","R0","R1","R2","R3","R4","R5","R6","R7","R8","R9","RA","RB","RD","RZ"};
	String[] EN_Courses={"E0","E1","E2","E3","E4","E5","E6","E7","E8","E9","F0","F1","F2","F3","F4","F5","F6","F7","F8","F9",
						 "N0","N1","N3","N4","N5","N6","N8","N9","P1","P4","P5","P6","P8","NA","NB","NC"};
	String[] FS_Courses={"C1","C2","C3","C4","F8","L1","L2","L3","L4","L7","LA","VF"};
	String[] LS_Courses={"B1","B2","B3","B5","K1","K2","K3","K4","K5"};
	String[] GE_Courses={"A1","A7","A8","A9","AG"};
	String[] OE_Courses={"A2","A3","A4","A5","A6","AA","AH","AN"};
	String[][] ALL_Courses={EE_Courses,SS_Courses,MS_Courses,EN_Courses,FS_Courses,LS_Courses,GE_Courses,OE_Courses,MD_Courses};
	
	
	
		
	OpenData2(){
		
			
			
		
	}
	public  int parse_teacher(int mod_select,String str,String input)throws IOException,FileNotFoundException{

		 
		//String input;
		
		//Scanner sc = new Scanner(System.in);
		//input = sc.next();
		//System.out.println("��J��Ƭd�ߤ��A�еy��......");
		String url_orig = "http://140.116.165.74/qry/qry001.php?dept_no=";
		//url_str = url_orig + str ;
		URL url = null;
		Document doc = null;
		Element jsElms = null;
		File fr = null;
		ListIterator <Element> iter = null;
		
		
		if(mod_select==1){
			String url_str = url_orig + str ;
			url = new URL(url_str);
			doc = Jsoup.parse(url, 3000); 
			jsElms = doc.select("table").get(0);  
			iter = jsElms.select("td").listIterator();  
		}else{
			String url_file =  str +".html";
			fr = new File(url_file);
			if(!fr.exists()){
				System.out.println("���a�ݵL���ɮסA��s��");
				load_url_file(url_orig+str,str);
				
			}
			doc = Jsoup.parse(fr, null); 
			jsElms = doc.select("table").get(0);  
			iter = jsElms.select("td").listIterator();
		}
		
		
		boolean find = false;
		String mt = null;
		
		while(iter.hasNext())  
		{  
			
			mt = iter.next().text();
			//Iterator <Element> col = 
			if(input.equals(mt)){
				//System.out.println("���F"+mt);
				for(int i=0;i<13;i++)
				if(iter.hasPrevious()==true)iter.previous();
				
				mt = iter.next().text();
				for(int i=0;i<22;i++){
					System.out.print(mt+" ");
					if(iter.hasNext())mt = iter.next().text();
					else break;}
				
				System.out.println("");
				find = true;
				break;
			}
				
			
		}
		if(!find){
			//System.out.println("�䤣��P "+mt+" ���������");
			//System.out.println("-----------------");
			return 0;
		}else{
			//System.out.println("-----------------");
			return 1;
		}
			
		
	}
	public void teacher_finder(int mod_select){
		System.out.println("�п�J�A�n�䪺�ǰ|(�w�]�OEE)");
		System.out.println("EE ��� �q����T�ǰ|");
		System.out.println("SS ��� ���|��Ǿǰ|");
		System.out.println("MD ��� ��ǰ|");
		System.out.println("MS ��� �޲z�ǰ|");
		System.out.println("EN ��� �u�ǰ|");
		System.out.println("FS ��� �z�ǰ|");
		System.out.println("LS ��� ��ǰ|");
		System.out.println("GE ��� �q�ѽҵ{");
		System.out.println("OE ��� ��L�ҵ{");
		System.out.println("ALL ��� �����j�M");
		System.out.print("�A����ܬO: ");
		Scanner sc = new Scanner(System.in);
		String opt = sc.next();
		
		String tea = null;
		try{
			if(opt.equals("SS")){
				System.out.println("�п�J�A�n�d�ߪ��ҵ{�Ѯv�W��:");
				tea = sc.next();
				System.out.println("��J��Ƭd�ߤ��A�еy��......");
				for(String str:SS_Courses){
				
				parse_teacher(mod_select,str,tea);
				}
				System.out.println("�j������");
			}else if(opt.equals("MD")){
				System.out.println("�п�J�A�n�d�ߪ��ҵ{�Ѯv�W��:");
				tea = sc.next();
				System.out.println("��J��Ƭd�ߤ��A�еy��......");
				for(String str:MD_Courses){
				
				parse_teacher(mod_select,str,tea);
				}
				System.out.println("�j������");
				
			}else if(opt.equals("MS")){
				System.out.println("�п�J�A�n�d�ߪ��ҵ{�Ѯv�W��:");
				tea = sc.next();
				System.out.println("��J��Ƭd�ߤ��A�еy��......");
				for(String str:MS_Courses){
				
				parse_teacher(mod_select,str,tea);
				}
				System.out.println("�j������");
				
			}else if(opt.equals("EN")){
				System.out.println("�п�J�A�n�d�ߪ��ҵ{�Ѯv�W��:");
				tea = sc.next();
				System.out.println("��J��Ƭd�ߤ��A�еy��......");
				for(String str:EN_Courses){
				
				parse_teacher(mod_select,str,tea);
				}
				System.out.println("�j������");
				
			}else if(opt.equals("FS")){
				System.out.println("�п�J�A�n�d�ߪ��ҵ{�Ѯv�W��:");
				tea = sc.next();
				System.out.println("��J��Ƭd�ߤ��A�еy��......");
				for(String str:FS_Courses){
				
				parse_teacher(mod_select,str,tea);
				}
				System.out.println("�j������");
				
			}else if(opt.equals("LS")){
				System.out.println("�п�J�A�n�d�ߪ��ҵ{�Ѯv�W��:");
				tea = sc.next();
				System.out.println("��J��Ƭd�ߤ��A�еy��......");
				for(String str:LS_Courses){
				
				parse_teacher(mod_select,str,tea);
				}
				System.out.println("�j������");
				
			}else if(opt.equals("GE")){
				System.out.println("�п�J�A�n�d�ߪ��ҵ{�Ѯv�W��:");
				tea = sc.next();
				System.out.println("��J��Ƭd�ߤ��A�еy��......");
				for(String str:GE_Courses){
				
				parse_teacher(mod_select,str,tea);
				}
				System.out.println("�j������");
				
			}else if(opt.equals("OE")){
				System.out.println("�п�J�A�n�d�ߪ��ҵ{�Ѯv�W��:");
				tea = sc.next();
				System.out.println("��J��Ƭd�ߤ��A�еy��......");
				for(String str:OE_Courses){
				
				parse_teacher(mod_select,str,tea);
				}
				System.out.println("�j������");
				
			}else if(opt.equals("ALL")){
				System.out.println("�п�J�A�n�d�ߪ��ҵ{�Ѯv�W��:");
				tea = sc.next();
				System.out.println("��J��Ƭd�ߤ��A�еy��......");
				for(String[] CLG:ALL_Courses)
				for(String str:CLG){
				
				parse_teacher(mod_select,str,tea);
				}
				System.out.println("�j������");
				
			}else{
				System.out.println("�п�J�A�n�d�ߪ��ҵ{�Ѯv�W��:");
				tea = sc.next();
				System.out.println("��J��Ƭd�ߤ��A�еy��......");
				for(String str:EE_Courses){
				;
				parse_teacher(mod_select,str,tea);
				//System.out.println(url_add+" "+tea);
				}	
				System.out.println("�j������");
				
			}
		
		}catch(java.net.SocketTimeoutException e){System.out.println("�s�u�O��");}
		catch(FileNotFoundException e){System.out.println("�t�Χ䤣���ɮ�Ū��");}
		catch(IOException e){e.printStackTrace();}
		
	}
	 public void all_url_load(){
		 String url_orig = "http://140.116.165.74/qry/qry001.php?dept_no=";
		 for(String[] CLG:ALL_Courses)
			 for(String str:CLG){
				 String url_add = url_orig + str;
				 load_url_file(url_add,str);
			 }
		 System.out.println("Done all file�w��s�������a�ݸ��");
	 }
	 public void load_url_file(String inp,String sv){
		 
		 
			 try{
			 //String inp ="http://140.116.165.74/qry/qry001.php?dept_no=F7";
			 //String sv = "F7.html";
				 sv = sv +".html";
			 URL src = new URL(inp);
			 BufferedInputStream br = new BufferedInputStream(src.openStream());
			 byte[] b = new byte[1024];
			 FileOutputStream fs = new FileOutputStream(sv);
			 int len;
			 while((len=br.read(b,0,b.length))!=-1){
				 fs.write(b);
			 }
			 br.close();
			 fs.close();
			 }catch(IOException e){e.printStackTrace();}
			 System.out.println(sv+" Done");
	 }
	 public static void main(String args[])throws IOException {
			
			OpenData2 op = new OpenData2();
			//String str1 = "http://140.116.165.74/qry/qry001.php?dept_no=F7";
			//System.out.println("�п�J�A�n�d�ߪ��ҵ{�Ѯv�W��:");
			//op.all_url_load();
			Scanner sc = new Scanner (System.in);
			int select_mod = 2;
			System.out.println("��1-�����b�����Wparse ��2-�ϥΥ��a�ݸ��  ");
			select_mod = sc.nextInt();
			if(select_mod==1)op.teacher_finder(1);
			else if(select_mod==2){
				System.out.println("�O�_�n��s���a�ݸ��  ");
				System.out.println("��1-�O  ��2-�_  ");
				int s = sc.nextInt();
				if(s==1)op.all_url_load();
				
				op.teacher_finder(2);	
			}
			
			
		}

	 
}

