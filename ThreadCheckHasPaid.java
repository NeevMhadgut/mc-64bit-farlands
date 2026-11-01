import java.net.HttpURLConnection;
import java.net.URL;
import net.minecraft.client.Minecraft;

public class ThreadCheckHasPaid extends Thread {
   final Minecraft a;

   public ThreadCheckHasPaid(Minecraft par1Minecraft) {
      this.a = par1Minecraft;
   }

   @Override
   public void run() {
      try {
         HttpURLConnection httpurlconnection = (HttpURLConnection)new URL("https://login.minecraft.net/session?name=" + this.a.k.b + "&session=" + this.a.k.c)
            .openConnection();
         httpurlconnection.connect();
         if (httpurlconnection.getResponseCode() == 400) {
            Minecraft.J = System.currentTimeMillis();
         }

         httpurlconnection.disconnect();
      } catch (Exception exception) {
         exception.printStackTrace();
      }
   }
}
