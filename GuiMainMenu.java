import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class GuiMainMenu extends vp {
   private static final Random a = new Random();
   private float b = 0.0F;
   private String c;
   private abp d;
   private int e = 0;
   private int f;

   public GuiMainMenu() {
      this.c = "missingno";

      try {
         ArrayList arraylist = new ArrayList();
         BufferedReader bufferedreader = new BufferedReader(
            new InputStreamReader(GuiMainMenu.class.getResourceAsStream("/title/splashes.txt"), Charset.forName("UTF-8"))
         );
         String s = "";

         String s1;
         while ((s1 = bufferedreader.readLine()) != null) {
            s1 = s1.trim();
            if (s1.length() > 0) {
               arraylist.add(s1);
            }
         }

         do {
            this.c = (String)arraylist.get(a.nextInt(arraylist.size()));
         } while (this.c.hashCode() == 125780783);
      } catch (Exception var5) {
      }

      int customSplashInt = a.nextInt(20);
      if (customSplashInt == 0) {
         this.c = "Mod by 314rft!";
      } else if (customSplashInt == 1) {
         this.c = "Thanks WorldGenTallGrass MrLordSith!";
      } else if (customSplashInt == 2) {
         this.c = "Thanks WorldGenTallGrass DraydenSpace!";
      } else if (customSplashInt == 3) {
         this.c = "Absolutely squid free!";
      }

      this.b = a.nextFloat();
   }

   public void a() {
      this.e++;
   }

   public boolean b() {
      return false;
   }

   protected void a(char c, int i) {
   }

   public void c() {
      this.f = this.p.p.a(new BufferedImage(256, 256, 2));
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(new Date());
      if (calendar.get(2) + 1 == 11 && calendar.get(5) == 9) {
         this.c = "Happy birthday, ez!";
      } else if (calendar.get(2) + 1 == 6 && calendar.get(5) == 1) {
         this.c = "Happy birthday, Notch!";
      } else if (calendar.get(2) + 1 == 12 && calendar.get(5) == 24) {
         this.c = "Merry X-mas!";
      } else if (calendar.get(2) + 1 == 1 && calendar.get(5) == 1) {
         this.c = "Happy new year!";
      }

      adn stringtranslate = adn.a();
      int i = this.r / 4 + 48;
      this.s.add(new abp(1, this.q / 2 - 100, i, stringtranslate.b("menu.singleplayer")));
      this.s.add(this.d = new abp(2, this.q / 2 - 100, i + 24, stringtranslate.b("menu.multiplayer")));
      this.s.add(new abp(3, this.q / 2 - 100, i + 48, stringtranslate.b("menu.mods")));
      if (this.p.n) {
         this.s.add(new abp(0, this.q / 2 - 100, i + 72, stringtranslate.b("menu.options")));
      } else {
         this.s.add(new abp(0, this.q / 2 - 100, i + 72 + 12, 98, 20, stringtranslate.b("menu.options")));
         this.s.add(new abp(4, this.q / 2 + 2, i + 72 + 12, 98, 20, stringtranslate.b("menu.quit")));
      }

      this.s.add(new adr(5, this.q / 2 - 124, i + 72 + 12));
      if (this.p.k == null) {
         this.d.h = false;
      }
   }

   protected void a(abp par1GuiButton) {
      if (par1GuiButton.f == 0) {
         this.p.a(new cd(this, this.p.A));
      }

      if (par1GuiButton.f == 5) {
         this.p.a(new afv(this, this.p.A));
      }

      if (par1GuiButton.f == 1) {
         this.p.a(new mw(this));
      }

      if (par1GuiButton.f == 2) {
         this.p.a(new acp(this));
      }

      if (par1GuiButton.f == 3) {
         this.p.a(new em(this));
      }

      if (par1GuiButton.f == 4) {
         this.p.f();
      }
   }

   private void b(int par1, int par2, float par3) {
      Tessellator tessellator = Tessellator.a;
      GL11.glMatrixMode(5889);
      GL11.glPushMatrix();
      GL11.glLoadIdentity();
      GLU.gluPerspective(120.0F, 1.0F, 0.05F, 10.0F);
      GL11.glMatrixMode(5888);
      GL11.glPushMatrix();
      GL11.glLoadIdentity();
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
      GL11.glEnable(3042);
      GL11.glDisable(3008);
      GL11.glDisable(2884);
      GL11.glDepthMask(false);
      GL11.glBlendFunc(770, 771);
      int i = 8;

      for (int j = 0; j < i * i; j++) {
         GL11.glPushMatrix();
         float f = ((float)(j % i) / i - 0.5F) / 64.0F;
         float f1 = ((float)(j / i) / i - 0.5F) / 64.0F;
         float f2 = 0.0F;
         GL11.glTranslatef(f, f1, f2);
         GL11.glRotatef(MathHelper.a((this.e + par3) / 400.0F) * 25.0F + 20.0F, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(-(this.e + par3) * 0.1F, 0.0F, 1.0F, 0.0F);

         for (int k = 0; k < 6; k++) {
            GL11.glPushMatrix();
            if (k == 1) {
               GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
            }

            if (k == 2) {
               GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
            }

            if (k == 3) {
               GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
            }

            if (k == 4) {
               GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
            }

            if (k == 5) {
               GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
            }

            GL11.glBindTexture(3553, this.p.p.b("/title/bg/panorama" + k + ".png"));
            tessellator.b();
            tessellator.a(16777215, 255 / (j + 1));
            float f3 = 0.0F;
            tessellator.a(-1.0, -1.0, 1.0, 0.0F + f3, 0.0F + f3);
            tessellator.a(1.0, -1.0, 1.0, 1.0F - f3, 0.0F + f3);
            tessellator.a(1.0, 1.0, 1.0, 1.0F - f3, 1.0F - f3);
            tessellator.a(-1.0, 1.0, 1.0, 0.0F + f3, 1.0F - f3);
            tessellator.a();
            GL11.glPopMatrix();
         }

         GL11.glPopMatrix();
         GL11.glColorMask(true, true, true, false);
      }

      tessellator.b(0.0, 0.0, 0.0);
      GL11.glColorMask(true, true, true, true);
      GL11.glMatrixMode(5889);
      GL11.glPopMatrix();
      GL11.glMatrixMode(5888);
      GL11.glPopMatrix();
      GL11.glDepthMask(true);
      GL11.glEnable(2884);
      GL11.glEnable(3008);
      GL11.glEnable(2929);
   }

   private void a(float par1) {
      GL11.glBindTexture(3553, this.f);
      GL11.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, 256, 256);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glColorMask(true, true, true, false);
      Tessellator tessellator = Tessellator.a;
      tessellator.b();
      byte byte0 = 3;

      for (int i = 0; i < byte0; i++) {
         tessellator.a(1.0F, 1.0F, 1.0F, 1.0F / (i + 1));
         int j = this.q;
         int k = this.r;
         float f = (i - byte0 / 2) / 256.0F;
         tessellator.a(j, k, this.g, 0.0F + f, 0.0);
         tessellator.a(j, 0.0, this.g, 1.0F + f, 0.0);
         tessellator.a(0.0, 0.0, this.g, 1.0F + f, 1.0);
         tessellator.a(0.0, k, this.g, 0.0F + f, 1.0);
      }

      tessellator.a();
      GL11.glColorMask(true, true, true, true);
   }

   private void c(int par1, int par2, float par3) {
      GL11.glViewport(0, 0, 256, 256);
      this.b(par1, par2, par3);
      GL11.glDisable(3553);
      GL11.glEnable(3553);
      this.a(par3);
      this.a(par3);
      this.a(par3);
      this.a(par3);
      this.a(par3);
      this.a(par3);
      this.a(par3);
      this.a(par3);
      GL11.glViewport(0, 0, this.p.d, this.p.e);
      Tessellator tessellator = Tessellator.a;
      tessellator.b();
      float f = this.q <= this.r ? 120.0F / this.r : 120.0F / this.q;
      float f1 = this.r * f / 256.0F;
      float f2 = this.q * f / 256.0F;
      GL11.glTexParameteri(3553, 10241, 9729);
      GL11.glTexParameteri(3553, 10240, 9729);
      tessellator.a(1.0F, 1.0F, 1.0F, 1.0F);
      int i = this.q;
      int j = this.r;
      tessellator.a(0.0, j, this.g, 0.5F - f1, 0.5F + f2);
      tessellator.a(i, j, this.g, 0.5F - f1, 0.5F - f2);
      tessellator.a(i, 0.0, this.g, 0.5F + f1, 0.5F - f2);
      tessellator.a(0.0, 0.0, this.g, 0.5F + f1, 0.5F + f2);
      tessellator.a();
   }

   public void a(int par1, int par2, float par3) {
      this.c(par1, par2, par3);
      Tessellator tessellator = Tessellator.a;
      char c = 274;
      int i = this.q / 2 - c / 2;
      byte byte0 = 30;
      this.a(0, 0, this.q, this.r, -2130706433, 16777215);
      this.a(0, 0, this.q, this.r, 0, Integer.MIN_VALUE);
      GL11.glBindTexture(3553, this.p.p.b("/title/mclogo.png"));
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      if (this.b < 1.0E-4) {
         this.b(i + 0, byte0 + 0, 0, 0, 99, 44);
         this.b(i + 99, byte0 + 0, 129, 0, 27, 44);
         this.b(i + 99 + 26, byte0 + 0, 126, 0, 3, 44);
         this.b(i + 99 + 26 + 3, byte0 + 0, 99, 0, 26, 44);
         this.b(i + 155, byte0 + 0, 0, 45, 155, 44);
      } else {
         this.b(i + 0, byte0 + 0, 0, 0, 155, 44);
         this.b(i + 155, byte0 + 0, 0, 45, 155, 44);
      }

      tessellator.c(16777215);
      GL11.glPushMatrix();
      GL11.glTranslatef(this.q / 2 + 90, 70.0F, 0.0F);
      GL11.glRotatef(-20.0F, 0.0F, 0.0F, 1.0F);
      float f = 1.8F - MathHelper.e(MathHelper.a((float)(System.currentTimeMillis() % 1000L) / 1000.0F * (float) Math.PI * 2.0F) * 0.1F);
      f = f * 100.0F / (this.u.a(this.c) + 32);
      GL11.glScalef(f, f, f);
      this.a(this.u, this.c, 0, -8, 16776960);
      GL11.glPopMatrix();
      this.b(this.u, "Minecraft 1.2.5", 2, this.r - 10, 16777215);
      String s = "Copyright Mojang AB. Do not distribute!";
      this.b(this.u, s, this.q - this.u.a(s) - 2, this.r - 10, 16777215);
      super.a(par1, par2, par3);
   }
}
