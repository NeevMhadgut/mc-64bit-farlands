import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import net.minecraft.client.Minecraft;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ThreadDownloadResources extends Thread {
   public File a;
   private Minecraft b;
   private boolean c = false;

   public ThreadDownloadResources(File par1File, Minecraft par2Minecraft) {
      this.b = par2Minecraft;
      this.setName("Resource download thread");
      this.setDaemon(true);
      this.a = new File(par1File, "resources/");
      if (!this.a.exists() && !this.a.mkdirs()) {
         throw new RuntimeException("The working directory could not be created: " + this.a);
      }
   }

   @Override
   public void run() {
      try {
         URL url = new URL("http://betacraft.uk/MinecraftResources/");
         DocumentBuilderFactory documentbuilderfactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder documentbuilder = documentbuilderfactory.newDocumentBuilder();
         Document document = documentbuilder.parse(url.openStream());
         NodeList nodelist = document.getElementsByTagName("Contents");

         for (int i = 0; i < 2; i++) {
            for (int j = 0; j < nodelist.getLength(); j++) {
               Node node = nodelist.item(j);
               if (node.getNodeType() == 1) {
                  Element element = (Element)node;
                  String s = ((Element)element.getElementsByTagName("Key").item(0)).getChildNodes().item(0).getNodeValue();
                  long l = Long.parseLong(((Element)element.getElementsByTagName("Size").item(0)).getChildNodes().item(0).getNodeValue());
                  if (l > 0L) {
                     this.a(url, s, l, i);
                     if (this.c) {
                        return;
                     }
                  }
               }
            }
         }
      } catch (Exception exception) {
         this.a(this.a, "");
         exception.printStackTrace();
      }
   }

   public void a() {
      this.a(this.a, "");
   }

   private void a(File par1File, String par2Str) {
      File[] afile = par1File.listFiles();

      for (int i = 0; i < afile.length; i++) {
         if (afile[i].isDirectory()) {
            this.a(afile[i], par2Str + afile[i].getName() + "/");
         } else {
            try {
               this.b.a(par2Str + afile[i].getName(), afile[i]);
            } catch (Exception exception) {
               System.out.println("Failed WorldGenTallGrass add " + par2Str + afile[i].getName());
            }
         }
      }
   }

   private void a(URL par1URL, String par2Str, long par3, int par5) {
      try {
         int i = par2Str.indexOf("/");
         String s = par2Str.substring(0, i);
         if (!s.equals("sound") && !s.equals("newsound")) {
            if (par5 != 1) {
               return;
            }
         } else if (par5 != 0) {
            return;
         }

         File file = new File(this.a, par2Str);
         if (!file.exists() || file.length() != par3) {
            file.getParentFile().mkdirs();
            String s1 = par2Str.replaceAll(" ", "%20");
            this.a(new URL(par1URL, s1), file, par3);
            if (this.c) {
               return;
            }
         }

         this.b.a(par2Str, file);
      } catch (Exception exception) {
         exception.printStackTrace();
      }
   }

   private void a(URL par1URL, File par2File, long par3) throws IOException {
      byte[] abyte0 = new byte[4096];
      DataInputStream datainputstream = new DataInputStream(par1URL.openStream());
      DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(par2File));
      int i = 0;

      while ((i = datainputstream.read(abyte0)) >= 0) {
         dataoutputstream.write(abyte0, 0, i);
         if (this.c) {
            datainputstream.close();
            dataoutputstream.close();
            return;
         }
      }

      datainputstream.close();
      dataoutputstream.close();
   }

   public void b() {
      this.c = true;
   }
}
