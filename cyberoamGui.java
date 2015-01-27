/*
 * Cyberoam.java
 * @author Manish kumar 
 * Created on Nov 14, 2013, 1:25:35 AM
 * please report any bug to manishchoudhary55@gmail.com
 */
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.io.*;
import java.net.*;
import java.util.Date;

public class  cyberoamGui extends javax.swing.JFrame implements Runnable {
	 Thread t;
     public cyberoamGui() {
        initComponents();
        t = new Thread(this, "Login Thread");
    }
/** 
 * This method is called from within the constructor to initialize the form.
 * WARNING: Do NOT modify this code. The content of this method is
 * always regenerated by the Form Editor.
*/
 @SuppressWarnings("unchecked")
private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jTextField1 = new javax.swing.JTextField();
    jButton1 = new javax.swing.JButton();
    jTextField2 = new javax.swing.JPasswordField();
    jLabel4 = new javax.swing.JLabel();
    jButton2 = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Cyberoam");
    setAlwaysOnTop(true);
    setBackground(new java.awt.Color(102, 102, 255));
    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    jLabel1.setText("Welcome to Cyberoam login client");
    jLabel2.setText("User name");
    jLabel3.setText("Password");
    jButton1.setText("login");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
	try {
		jButton1ActionPerformed(evt);
	} catch ( Exception e) {
		e.printStackTrace();
		}

         }
    });
   jButton2.setText("logout");
   jButton2.addActionListener(new java.awt.event.ActionListener() {
   	
   public void actionPerformed(java.awt.event.ActionEvent evt) {
	try{
		jButton2ActionPerformed(evt);
        }catch(Exception e){
	        e.printStackTrace();
	}
	}
   } );

	javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());

            getContentPane().setLayout(layout);

            layout.setHorizontalGroup(

                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()

                    .addGap(68, 68, 68)

                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))

                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()

                    .addContainerGap()

                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()

                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)

                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)

                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)

                                .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)

                                .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))

                            .addGap(49, 49, 49))

                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))

                .addGroup(layout.createSequentialGroup()

                    .addContainerGap()

                    .addComponent(jButton1)

                    .addGap(18, 18, 18)

                    .addComponent(jButton2)

                    .addContainerGap(239, Short.MAX_VALUE))

                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()

                    .addContainerGap()

                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))

            );

            layout.setVerticalGroup(

                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()

                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)

                    .addGap(18, 18, 18)

                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)

                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)

                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))

                    .addGap(18, 18, 18)

                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)

                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)

                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))

                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)

                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)

                    .addGap(18, 18, 18)

                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)

                        .addComponent(jButton1)

                        .addComponent(jButton2))

                    .addContainerGap())

            );



            pack();

        }// </editor-fold>

        

        public void login() throws Exception,IOException{

        	String username = jTextField1.getText();

    		@SuppressWarnings("deprecation")

			String passwd =  jTextField2.getText();

    		

    		//System.out.print("username "+username + "passwd "+passwd);

    		long a = System.currentTimeMillis();

    		String urlParameters = "mode=191&username="+username+"&password="+passwd+"&a="+a+"&producttype=0";

    		String request = "http://192.168.2.2:8090/login.xml";

    		URL url = new URL(request); 

    		HttpURLConnection connection = null;

    		try {

    			connection = (HttpURLConnection) url.openConnection();

    			

    		} catch (IOException e1) {

    			// TODO Auto-generated catch block

    			e1.printStackTrace();

    		}           

    		connection.setDoOutput(true);

    		connection.setDoInput(true);

    		connection.setInstanceFollowRedirects(false); 

    		try {

    			connection.setRequestMethod("POST");

    			

    		} catch (ProtocolException e) {

    			// TODO Auto-generated catch block

    			e.printStackTrace();

    		} 

    		

    		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 

    		connection.setRequestProperty("Referer","http://192.168.2.2:8090/httpclient.html");

    		connection.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes().length));

    		connection.setUseCaches (false);



    		DataOutputStream wr = new DataOutputStream(connection.getOutputStream ());

    		wr.writeBytes(urlParameters);

    		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine,ab=null;



           while ((inputLine = in.readLine()) != null)

        	   ab = ab + inputLine;

           //System.out.println(ab);

           int start = ab.indexOf("CDATA[");

           int last = ab.indexOf("]]");

           String message =(String) ab.subSequence(start+6, last);

           System.out.println("message "+message);

           in.close(); 

    		wr.flush();

    		wr.close();

    		jLabel4.setText(message);

    		

        }

        

        

        void logout(){

        	System.out.print("Logout");

        	System.exit(0);

        }

        

        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)  throws Exception,IOException {

            // TODO add your handling code here:

        	String button_lable = null;
        	try{
        	t.start();
        	}catch(Exception er){
        		System.out.println("Error : " + er);
        	}finally{
        		t.destroy();
        	}
        	

        }

        public void run() {

            //System.out.println("Inside run()function");

            try{

            while(true){

            	login();

            	Thread.sleep(24000);

            }	

            }catch(Exception E){

            	System.out.println(E);

            	

            }

         }

         

        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {

            // TODO add your handling code here:

        	logout();

        }



        /**

        * @param args the command line arguments

        */

        public static void main(String args[]) {

            java.awt.EventQueue.invokeLater(new Runnable() {

                public void run() {

                 cyberoamGui g =   new cyberoamGui();

                 g.setVisible(true);

                }

            });

        }



        // Variables declaration - do not modify

        private javax.swing.JLabel jLabel4;

        private javax.swing.JButton jButton1;

        private javax.swing.JButton jButton2;

        private javax.swing.JLabel jLabel1;

        private javax.swing.JLabel jLabel2;

        private javax.swing.JLabel jLabel3;

        private javax.swing.JTextField jTextField1;

        private javax.swing.JPasswordField jTextField2;

        // End of variables declaration



    }
