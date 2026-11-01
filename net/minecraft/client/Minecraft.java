package net.minecraft.client;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.io.File;
import java.text.DecimalFormat;
import java.util.List;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Controllers;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;
import org.lwjgl.util.glu.GLU;

public abstract class Minecraft implements Runnable {
   public static byte[] b = new byte[10485760];
   private static Minecraft a;
   public ki c;
   private boolean U = false;
   private boolean V = false;
   public int d;
   public int e;
   private vm W;
   private aft X = new aft(20.0F);
   public xd f;
   public l g;
   public vq h;
   public acq i;
   public cw j;
   public fc k = null;
   public String l;
   public Canvas m;
   public boolean n = false;
   public volatile boolean o = false;
   public aaw p;
   public nl q;
   public nl r;
   public vp s = null;
   public jc t;
   public lr u;
   private ck Y;
   private int Z = 0;
   private int aa = 0;
   private int ab;
   private int ac;
   public qd v = new qd(this);
   public aiy w;
   public boolean x = false;
   public xg y = new xg(0.0F);
   public pl z = null;
   public hu A;
   protected MinecraftApplet B;
   public sd C = new sd();
   public aka D;
   public gi E;
   public File F;
   private kb ad;
   public static long[] G = new long[512];
   public static long[] H = new long[512];
   public static int I = 0;
   public static long J = 0L;
   private int ae = 0;
   public alf K;
   private String af;
   private int ag;
   private qa ah = new qa();
   private bv ai = new bv();
   private static File aj = null;
   public volatile boolean L = true;
   public String M = "";
   long N = System.currentTimeMillis();
   int O = 0;
   boolean P = false;
   long Q = -1L;
   private String ak = "root";
   public boolean R = false;
   public boolean S = false;
   long T = System.currentTimeMillis();
   private int al = 0;

   public Minecraft(Component par1Component, Canvas par2Canvas, MinecraftApplet par3MinecraftApplet, int par4, int par5, boolean par6) {
      gv.a();
      this.ac = par5;
      this.U = par6;
      this.B = par3MinecraftApplet;
      afd.b = 32767;
      new hj(this, "Timer hack thread");
      this.m = par2Canvas;
      this.d = par4;
      this.e = par5;
      this.U = par6;
      if (par3MinecraftApplet == null || "true".equals(par3MinecraftApplet.getParameter("stand-alone"))) {
         this.n = false;
      }

      a = this;
   }

   public void b(ja par1UnexpectedThrowable) {
      this.V = true;
      this.a(par1UnexpectedThrowable);
   }

   public abstract void a(ja var1);

   public void a(String par1Str, int par2) {
      this.af = par1Str;
      this.ag = par2;
   }

   public void a() throws LWJGLException {
      if (this.m != null) {
         Graphics g = this.m.getGraphics();
         if (g != null) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, this.d, this.e);
            g.dispose();
         }

         Display.setParent(this.m);
      } else if (this.U) {
         Display.setFullscreen(true);
         this.d = Display.getDisplayMode().getWidth();
         this.e = Display.getDisplayMode().getHeight();
         if (this.d <= 0) {
            this.d = 1;
         }

         if (this.e <= 0) {
            this.e = 1;
         }
      } else {
         Display.setDisplayMode(new DisplayMode(this.d, this.e));
      }

      Display.setTitle("Minecraft Minecraft 1.2.5");
      System.out.println("LWJGL Version: " + Sys.getVersion());

      try {
         PixelFormat pixelformat = new PixelFormat();
         pixelformat = pixelformat.withDepthBits(24);
         Display.create(pixelformat);
      } catch (LWJGLException lwjglexception) {
         lwjglexception.printStackTrace();

         try {
            Thread.sleep(1000L);
         } catch (InterruptedException var5) {
         }

         Display.create();
      }

      es.a();
      this.F = b();
      this.ad = new fp(new File(this.F, "saves"));
      this.A = new hu(this, this.F);
      this.E = new gi(this, this.F);
      this.p = new aaw(this.E, this.A);
      this.v();
      this.q = new nl(this.A, "/font/default.png", this.p, false);
      this.r = new nl(this.A, "/font/alternate.png", this.p, false);
      if (this.A.R != null) {
         adn.a().a(this.A.R);
         this.q.a(adn.a().d());
         this.q.b(adn.d(this.A.R));
      }

      zt.a(this.p.a("/misc/watercolor.png"));
      zv.a(this.p.a("/misc/grasscolor.png"));
      gu.a(this.p.a("/misc/foliagecolor.png"));
      this.u = new lr(this);
      ahu.a.f = new mn(this);
      this.K = new alf(this.k, this.F);
      dp.f.a(new hk(this));
      this.v();
      Mouse.create();
      this.D = new aka(this.m);

      try {
         Controllers.create();
      } catch (Exception exception) {
         exception.printStackTrace();
      }

      D();
      this.d("Pre startup");
      GL11.glEnable(3553);
      GL11.glShadeModel(7425);
      GL11.glClearDepth(1.0);
      GL11.glEnable(2929);
      GL11.glDepthFunc(515);
      GL11.glEnable(3008);
      GL11.glAlphaFunc(516, 0.1F);
      GL11.glCullFace(1029);
      GL11.glMatrixMode(5889);
      GL11.glLoadIdentity();
      GL11.glMatrixMode(5888);
      this.d("Startup");
      this.W = new vm();
      this.C.a(this.A);
      this.p.a(this.ai);
      this.p.a(this.ah);
      this.p.a(new zp());
      this.p.a(new tu(this));
      this.p.a(new ht(this));
      this.p.a(new ael());
      this.p.a(new gf());
      this.p.a(new nh(0));
      this.p.a(new nh(1));
      this.g = new l(this, this.p);
      GL11.glViewport(0, 0, this.d, this.e);
      this.j = new cw(this.f, this.p);

      try {
         this.Y = new ck(this.F, this);
         this.Y.start();
      } catch (Exception var3) {
      }

      this.d("Post startup");
      this.w = new aiy(this);
      if (this.af != null) {
         this.a(new ajy(this, this.af, this.ag));
      } else {
         this.a(new xt());
      }

      this.t = new jc(this);
   }

   private void v() throws LWJGLException {
      agd scaledresolution = new agd(this.A, this.d, this.e);
      GL11.glClear(16640);
      GL11.glMatrixMode(5889);
      GL11.glLoadIdentity();
      GL11.glOrtho(0.0, scaledresolution.a, scaledresolution.b, 0.0, 1000.0, 3000.0);
      GL11.glMatrixMode(5888);
      GL11.glLoadIdentity();
      GL11.glTranslatef(0.0F, 0.0F, -2000.0F);
      GL11.glViewport(0, 0, this.d, this.e);
      GL11.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      adz tessellator = adz.a;
      GL11.glDisable(2896);
      GL11.glEnable(3553);
      GL11.glDisable(2912);
      GL11.glBindTexture(3553, this.p.b("/title/mojang.png"));
      tessellator.b();
      tessellator.c(16777215);
      tessellator.a(0.0, this.e, 0.0, 0.0, 0.0);
      tessellator.a(this.d, this.e, 0.0, 0.0, 0.0);
      tessellator.a(this.d, 0.0, 0.0, 0.0, 0.0);
      tessellator.a(0.0, 0.0, 0.0, 0.0, 0.0);
      tessellator.a();
      char c = 256;
      char c1 = 256;
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      tessellator.c(16777215);
      this.a((scaledresolution.a() - c) / 2, (scaledresolution.b() - c1) / 2, 0, 0, c, c1);
      GL11.glDisable(2896);
      GL11.glDisable(2912);
      GL11.glEnable(3008);
      GL11.glAlphaFunc(516, 0.1F);
      Display.swapBuffers();
   }

   public void a(int par1, int par2, int par3, int par4, int par5, int par6) {
      float f = 0.00390625F;
      float f1 = 0.00390625F;
      adz tessellator = adz.a;
      tessellator.b();
      tessellator.a(par1 + 0, par2 + par6, 0.0, (par3 + 0) * f, (par4 + par6) * f1);
      tessellator.a(par1 + par5, par2 + par6, 0.0, (par3 + par5) * f, (par4 + par6) * f1);
      tessellator.a(par1 + par5, par2 + 0, 0.0, (par3 + par5) * f, (par4 + 0) * f1);
      tessellator.a(par1 + 0, par2 + 0, 0.0, (par3 + 0) * f, (par4 + 0) * f1);
      tessellator.a();
   }

   public static File b() {
      if (aj == null) {
         aj = a("minecraft");
      }

      return aj;
   }

   // $VF: Unable to simplify switch on enum
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public static File a(String par0Str) {
      String s = System.getProperty("user.home", ".");
      File file;
      switch (hn.a[w().ordinal()]) {
         case 1:
         case 2:
            file = new File(s, '.' + par0Str + '/');
            break;
         case 3:
            String s1 = System.getenv("APPDATA");
            if (s1 != null) {
               file = new File(s1, "." + par0Str + '/');
            } else {
               file = new File(s, '.' + par0Str + '/');
            }
            break;
         case 4:
            file = new File(s, "Library/Application Support/" + par0Str);
            break;
         default:
            file = new File(s, par0Str + '/');
      }

      if (!file.exists() && !file.mkdirs()) {
         throw new RuntimeException("The working directory could not be created: " + file);
      } else {
         return file;
      }
   }

   private static afa w() {
      String s = System.getProperty("os.name").toLowerCase();
      if (s.contains("win")) {
         return afa.c;
      } else if (s.contains("mac")) {
         return afa.d;
      } else if (s.contains("solaris")) {
         return afa.b;
      } else if (s.contains("sunos")) {
         return afa.b;
      } else if (s.contains("linux")) {
         return afa.a;
      } else {
         return s.contains("unix") ? afa.a : afa.e;
      }
   }

   public kb c() {
      return this.ad;
   }

   public void a(vp par1GuiScreen) {
      if (!(this.s instanceof uw)) {
         if (this.s != null) {
            this.s.e();
         }

         if (par1GuiScreen instanceof xt) {
            this.K.b();
         }

         this.K.c();
         if (par1GuiScreen == null && this.f == null) {
            par1GuiScreen = new xt();
         } else if (par1GuiScreen == null && this.h.bb() <= 0) {
            par1GuiScreen = new uy();
         }

         if (par1GuiScreen instanceof xt) {
            this.A.F = false;
            this.w.b();
         }

         this.s = par1GuiScreen;
         if (par1GuiScreen != null) {
            this.h();
            agd scaledresolution = new agd(this.A, this.d, this.e);
            int i = scaledresolution.a();
            int j = scaledresolution.b();
            par1GuiScreen.a(this, i, j);
            this.x = false;
         } else {
            this.g();
         }
      }
   }

   private void d(String par1Str) {
      int i = GL11.glGetError();
      if (i != 0) {
         String s = GLU.gluErrorString(i);
         System.out.println("########## GL ERROR ##########");
         System.out.println("@ " + par1Str);
         System.out.println(i + ": " + s);
      }
   }

   public void d() {
      try {
         this.K.b();
         this.K.c();
         if (this.B != null) {
            this.B.c();
         }

         try {
            if (this.Y != null) {
               this.Y.b();
            }
         } catch (Exception var9) {
         }

         System.out.println("Stopping!");

         try {
            this.a((xd)null);
         } catch (Throwable var8) {
         }

         try {
            ew.a();
         } catch (Throwable var7) {
         }

         this.C.b();
         Mouse.destroy();
         Keyboard.destroy();
      } finally {
         Display.destroy();
         if (!this.V) {
            System.exit(0);
         }
      }

      System.gc();
   }

   @Override
   public void run() {
      this.L = true;

      try {
         this.a();
      } catch (Exception exception) {
         exception.printStackTrace();
         this.b(new ja("Failed to start game", exception));
         return;
      }

      try {
         while (this.L) {
            try {
               this.x();
            } catch (aiz minecraftexception) {
               this.f = null;
               this.a((xd)null);
               this.a(new afx());
            } catch (OutOfMemoryError outofmemoryerror) {
               this.e();
               this.a(new ti());
               System.gc();
            }
         }
      } catch (ru var12) {
      } catch (Throwable throwable) {
         this.e();
         throwable.printStackTrace();
         this.b(new ja("Unexpected error", throwable));
      } finally {
         this.d();
      }
   }

   private void x() {
      if (this.B != null && !this.B.isActive()) {
         this.L = false;
      } else {
         wu.b();
         bo.b();
         lv.a("root");
         if (this.m == null && Display.isCloseRequested()) {
            this.f();
         }

         if (this.o && this.f != null) {
            float f = this.X.c;
            this.X.a();
            this.X.c = f;
         } else {
            this.X.a();
         }

         long l = System.nanoTime();
         lv.a("tick");

         for (int i = 0; i < this.X.b; i++) {
            this.Z++;

            try {
               this.k();
            } catch (aiz minecraftexception) {
               this.f = null;
               this.a((xd)null);
               this.a(new afx());
            }
         }

         lv.b();
         long l1 = System.nanoTime() - l;
         this.d("Pre render");
         vl.b = this.A.j;
         lv.a("sound");
         this.C.a(this.h, this.X.c);
         lv.c("updatelights");
         if (this.f != null) {
            this.f.H();
         }

         lv.b();
         lv.a("render");
         lv.a("display");
         GL11.glEnable(3553);
         if (!Keyboard.isKeyDown(65)) {
            Display.update();
         }

         if (this.h != null && this.h.N()) {
            this.A.E = 0;
         }

         lv.b();
         if (!this.x) {
            lv.a("gameMode");
            if (this.c != null) {
               this.c.a(this.X.c);
            }

            lv.c("gameRenderer");
            this.u.b(this.X.c);
            lv.b();
         }

         GL11.glFlush();
         lv.b();
         if (!Display.isActive() && this.U) {
            this.j();
         }

         lv.b();
         if (this.A.F && this.A.G) {
            if (!lv.a) {
               lv.a();
            }

            lv.a = true;
            this.a(l1);
         } else {
            lv.a = false;
            this.Q = System.nanoTime();
         }

         this.v.a();
         lv.a("root");
         Thread.yield();
         if (Keyboard.isKeyDown(65)) {
            Display.update();
         }

         this.y();
         if (this.m != null && !this.U && (this.m.getWidth() != this.d || this.m.getHeight() != this.e)) {
            this.d = this.m.getWidth();
            this.e = this.m.getHeight();
            if (this.d <= 0) {
               this.d = 1;
            }

            if (this.e <= 0) {
               this.e = 1;
            }

            this.a(this.d, this.e);
         }

         this.d("Post render");
         this.O++;

         for (this.o = !this.l() && this.s != null && this.s.b(); System.currentTimeMillis() >= this.N + 1000L; this.O = 0) {
            this.M = this.O + " fps, " + ct.b + " chunk updates";
            ct.b = 0;
            this.N += 1000L;
         }

         lv.b();
      }
   }

   public void e() {
      try {
         b = new byte[0];
         this.g.e();
      } catch (Throwable var4) {
      }

      try {
         System.gc();
         wu.a();
         bo.a();
      } catch (Throwable var3) {
      }

      try {
         System.gc();
         this.a((xd)null);
      } catch (Throwable var2) {
      }

      System.gc();
   }

   private void y() {
      if (Keyboard.isKeyDown(60)) {
         if (!this.P) {
            this.P = true;
            this.w.a(zh.a(aj, this.d, this.e));
         }
      } else {
         this.P = false;
      }
   }

   private void b(int par1) {
      List list = lv.b(this.ak);
      if (list != null && list.size() != 0) {
         aaf profilerresult = (aaf)list.remove(0);
         if (par1 == 0) {
            if (profilerresult.c.length() > 0) {
               int i = this.ak.lastIndexOf(".");
               if (i >= 0) {
                  this.ak = this.ak.substring(0, i);
               }
            }
         } else {
            par1--;
            if (par1 < list.size() && !((aaf)list.get(par1)).c.equals("unspecified")) {
               if (this.ak.length() > 0) {
                  this.ak = this.ak + ".";
               }

               this.ak = this.ak + ((aaf)list.get(par1)).c;
            }
         }
      }
   }

   private void a(long par1) {
      List list = lv.b(this.ak);
      aaf profilerresult = (aaf)list.remove(0);
      long l = 16666666L;
      if (this.Q == -1L) {
         this.Q = System.nanoTime();
      }

      long l1 = System.nanoTime();
      H[I & G.length - 1] = par1;
      G[I++ & G.length - 1] = l1 - this.Q;
      this.Q = l1;
      GL11.glClear(256);
      GL11.glMatrixMode(5889);
      GL11.glEnable(2903);
      GL11.glLoadIdentity();
      GL11.glOrtho(0.0, this.d, this.e, 0.0, 1000.0, 3000.0);
      GL11.glMatrixMode(5888);
      GL11.glLoadIdentity();
      GL11.glTranslatef(0.0F, 0.0F, -2000.0F);
      GL11.glLineWidth(1.0F);
      GL11.glDisable(3553);
      adz tessellator = adz.a;
      tessellator.a(7);
      int i = (int)(l / 200000L);
      tessellator.c(536870912);
      tessellator.a(0.0, this.e - i, 0.0);
      tessellator.a(0.0, this.e, 0.0);
      tessellator.a(G.length, this.e, 0.0);
      tessellator.a(G.length, this.e - i, 0.0);
      tessellator.c(538968064);
      tessellator.a(0.0, this.e - i * 2, 0.0);
      tessellator.a(0.0, this.e - i, 0.0);
      tessellator.a(G.length, this.e - i, 0.0);
      tessellator.a(G.length, this.e - i * 2, 0.0);
      tessellator.a();
      long l2 = 0L;

      for (int j = 0; j < G.length; j++) {
         l2 += G[j];
      }

      int k = (int)(l2 / 200000L / G.length);
      tessellator.a(7);
      tessellator.c(541065216);
      tessellator.a(0.0, this.e - k, 0.0);
      tessellator.a(0.0, this.e, 0.0);
      tessellator.a(G.length, this.e, 0.0);
      tessellator.a(G.length, this.e - k, 0.0);
      tessellator.a();
      tessellator.a(1);

      for (int i1 = 0; i1 < G.length; i1++) {
         int k1 = (i1 - I & G.length - 1) * 255 / G.length;
         int j2 = k1 * k1 / 255;
         j2 = j2 * j2 / 255;
         int i3 = j2 * j2 / 255;
         i3 = i3 * i3 / 255;
         if (G[i1] > l) {
            tessellator.c(-16777216 + j2 * 65536);
         } else {
            tessellator.c(-16777216 + j2 * 256);
         }

         long l3 = G[i1] / 200000L;
         long l4 = H[i1] / 200000L;
         tessellator.a(i1 + 0.5F, (float)(this.e - l3) + 0.5F, 0.0);
         tessellator.a(i1 + 0.5F, this.e + 0.5F, 0.0);
         tessellator.c(-16777216 + j2 * 65536 + j2 * 256 + j2 * 1);
         tessellator.a(i1 + 0.5F, (float)(this.e - l3) + 0.5F, 0.0);
         tessellator.a(i1 + 0.5F, (float)(this.e - (l3 - l4)) + 0.5F, 0.0);
      }

      tessellator.a();
      int j1 = 160;
      int i2 = this.d - j1 - 10;
      int k2 = this.e - j1 * 2;
      GL11.glEnable(3042);
      tessellator.b();
      tessellator.a(0, 200);
      tessellator.a(i2 - j1 * 1.1F, k2 - j1 * 0.6F - 16.0F, 0.0);
      tessellator.a(i2 - j1 * 1.1F, k2 + j1 * 2, 0.0);
      tessellator.a(i2 + j1 * 1.1F, k2 + j1 * 2, 0.0);
      tessellator.a(i2 + j1 * 1.1F, k2 - j1 * 0.6F - 16.0F, 0.0);
      tessellator.a();
      GL11.glDisable(3042);
      double d = 0.0;

      for (int j3 = 0; j3 < list.size(); j3++) {
         aaf profilerresult1 = (aaf)list.get(j3);
         int i4 = gk.c(profilerresult1.a / 4.0) + 1;
         tessellator.a(6);
         tessellator.c(profilerresult1.a());
         tessellator.a(i2, k2, 0.0);

         for (int k4 = i4; k4 >= 0; k4--) {
            float f = (float)((d + profilerresult1.a * k4 / i4) * Math.PI * 2.0 / 100.0);
            float f2 = gk.a(f) * j1;
            float f4 = gk.b(f) * j1 * 0.5F;
            tessellator.a(i2 + f2, k2 - f4, 0.0);
         }

         tessellator.a();
         tessellator.a(5);
         tessellator.c((profilerresult1.a() & 16711422) >> 1);

         for (int i5 = i4; i5 >= 0; i5--) {
            float f1 = (float)((d + profilerresult1.a * i5 / i4) * Math.PI * 2.0 / 100.0);
            float f3 = gk.a(f1) * j1;
            float f5 = gk.b(f1) * j1 * 0.5F;
            tessellator.a(i2 + f3, k2 - f5, 0.0);
            tessellator.a(i2 + f3, k2 - f5 + 10.0F, 0.0);
         }

         tessellator.a();
         d += profilerresult1.a;
      }

      DecimalFormat decimalformat = new DecimalFormat("##0.00");
      GL11.glEnable(3553);
      String s = "";
      if (!profilerresult.c.equals("unspecified")) {
         s = s + "[0] ";
      }

      if (profilerresult.c.length() == 0) {
         s = s + "ROOT ";
      } else {
         s = s + profilerresult.c + " ";
      }

      int j4 = 16777215;
      this.q.a(s, i2 - j1, k2 - j1 / 2 - 16, j4);
      this.q.a(s = decimalformat.format(profilerresult.b) + "%", i2 + j1 - this.q.a(s), k2 - j1 / 2 - 16, j4);

      for (int k3 = 0; k3 < list.size(); k3++) {
         aaf profilerresult2 = (aaf)list.get(k3);
         String s1 = "";
         if (!profilerresult2.c.equals("unspecified")) {
            s1 = s1 + "[" + (k3 + 1) + "] ";
         } else {
            s1 = s1 + "[?] ";
         }

         s1 = s1 + profilerresult2.c;
         this.q.a(s1, i2 - j1, k2 + j1 / 2 + k3 * 8 + 20, profilerresult2.a());
         this.q.a(s1 = decimalformat.format(profilerresult2.a) + "%", i2 + j1 - 50 - this.q.a(s1), k2 + j1 / 2 + k3 * 8 + 20, profilerresult2.a());
         this.q.a(s1 = decimalformat.format(profilerresult2.b) + "%", i2 + j1 - this.q.a(s1), k2 + j1 / 2 + k3 * 8 + 20, profilerresult2.a());
      }
   }

   public void f() {
      this.L = false;
   }

   public void g() {
      if (Display.isActive()) {
         if (!this.R) {
            this.R = true;
            this.D.a();
            this.a((vp)null);
            this.aa = 10000;
         }
      }
   }

   public void h() {
      if (this.R) {
         afu.a();
         this.R = false;
         this.D.b();
      }
   }

   public void i() {
      if (this.s == null) {
         this.a(new lb());
      }
   }

   private void a(int par1, boolean par2) {
      if (!par2) {
         this.aa = 0;
      }

      if (par1 != 0 || this.aa <= 0) {
         if (par2 && this.z != null && this.z.a == aat.a && par1 == 0) {
            long i = this.z.b;
            int j = this.z.c;
            long k = this.z.d;
            this.c.onPlayerDamageBlock(i, j, k, this.z.e);
            if (this.h.canPlayerEdit(i, j, k)) {
               this.j.addBlockHitEffects(i, j, k, this.z.e);
               this.h.ax();
            }
         } else {
            this.c.a();
         }
      }
   }

   private void c(int par1) {
      if (par1 != 0 || this.aa <= 0) {
         if (par1 == 0) {
            this.h.ax();
         }

         if (par1 == 1) {
            this.ae = 4;
         }

         boolean flag = true;
         aan itemstack = this.h.ap.b();
         if (this.z == null) {
            if (par1 == 0 && this.c.g()) {
               this.aa = 10;
            }
         } else if (this.z.a == aat.b) {
            if (par1 == 0) {
               this.c.b(this.h, this.z.g);
            }

            if (par1 == 1) {
               this.c.a(this.h, this.z.g);
            }
         } else if (this.z.a == aat.a) {
            long i = this.z.b;
            int j = this.z.c;
            long k = this.z.d;
            int l = this.z.e;
            if (par1 == 0) {
               this.c.clickBlock(i, j, k, this.z.e);
            } else {
               aan itemstack2 = itemstack;
               int i1 = itemstack2 == null ? 0 : itemstack2.a;
               if (this.c.onPlayerRightClick(this.h, this.f, itemstack2, i, j, k, l)) {
                  flag = false;
                  this.h.ax();
               }

               if (itemstack2 == null) {
                  return;
               }

               if (itemstack2.a == 0) {
                  this.h.ap.a[this.h.ap.c] = null;
               } else if (itemstack2.a != i1 || this.c.h()) {
                  this.u.c.b();
               }
            }
         }

         if (flag && par1 == 1) {
            aan itemstack1 = this.h.ap.b();
            if (itemstack1 != null && this.c.a(this.h, this.f, itemstack1)) {
               this.u.c.c();
            }
         }
      }
   }

   public void j() {
      try {
         this.U = !this.U;
         if (this.U) {
            Display.setDisplayMode(Display.getDesktopDisplayMode());
            this.d = Display.getDisplayMode().getWidth();
            this.e = Display.getDisplayMode().getHeight();
            if (this.d <= 0) {
               this.d = 1;
            }

            if (this.e <= 0) {
               this.e = 1;
            }
         } else {
            if (this.m != null) {
               this.d = this.m.getWidth();
               this.e = this.m.getHeight();
            } else {
               this.d = this.ab;
               this.e = this.ac;
            }

            if (this.d <= 0) {
               this.d = 1;
            }

            if (this.e <= 0) {
               this.e = 1;
            }
         }

         if (this.s != null) {
            this.a(this.d, this.e);
         }

         Display.setFullscreen(this.U);
         Display.update();
      } catch (Exception exception) {
         exception.printStackTrace();
      }
   }

   private void a(int par1, int par2) {
      if (par1 <= 0) {
         par1 = 1;
      }

      if (par2 <= 0) {
         par2 = 1;
      }

      this.d = par1;
      this.e = par2;
      if (this.s != null) {
         agd scaledresolution = new agd(this.A, par1, par2);
         int i = scaledresolution.a();
         int j = scaledresolution.b();
         this.s.a(this, i, j);
      }
   }

   private void z() {
      new hp(this).start();
   }

   public void k() {
      if (this.ae > 0) {
         this.ae--;
      }

      if (this.Z == 6000) {
         this.z();
      }

      lv.a("stats");
      this.K.d();
      lv.c("gui");
      if (!this.o) {
         this.w.a();
      }

      lv.c("pick");
      this.u.a(1.0F);
      lv.c("centerChunkSource");
      if (this.h != null) {
         ca ichunkprovider = this.f.z();
         if (ichunkprovider instanceof hy) {
            hy chunkproviderloadorgenerate = (hy)ichunkprovider;
            long k = gk.d(this.h.o) >> 4;
            long j1 = gk.d(this.h.q) >> 4;
            chunkproviderloadorgenerate.setCurrentChunkOver(k, j1);
         }
      }

      lv.c("gameMode");
      if (!this.o && this.f != null) {
         this.c.c();
      }

      GL11.glBindTexture(3553, this.p.b("/terrain.png"));
      lv.c("textures");
      if (!this.o) {
         this.p.a();
      }

      if (this.s == null && this.h != null) {
         if (this.h.bb() <= 0) {
            this.a((vp)null);
         } else if (this.h.az() && this.f != null && this.f.F) {
            this.a(new yj());
         }
      } else if (this.s != null && this.s instanceof yj && !this.h.az()) {
         this.a((vp)null);
      }

      if (this.s != null) {
         this.aa = 10000;
      }

      if (this.s != null) {
         this.s.i();
         if (this.s != null) {
            this.s.v.a();
            this.s.a();
         }
      }

      if (this.s == null || this.s.t) {
         lv.c("mouse");

         while (Mouse.next()) {
            afu.a(Mouse.getEventButton() - 100, Mouse.getEventButtonState());
            if (Mouse.getEventButtonState()) {
               afu.a(Mouse.getEventButton() - 100);
            }

            long l = System.currentTimeMillis() - this.T;
            if (l <= 200L) {
               int i1 = Mouse.getEventDWheel();
               if (i1 != 0) {
                  this.h.ap.c(i1);
                  if (this.A.I) {
                     if (i1 > 0) {
                        i1 = 1;
                     }

                     if (i1 < 0) {
                        i1 = -1;
                     }

                     this.A.L += i1 * 0.25F;
                  }
               }

               if (this.s == null) {
                  if (!this.R && Mouse.getEventButtonState()) {
                     this.g();
                  }
               } else if (this.s != null) {
                  this.s.f();
               }
            }
         }

         if (this.aa > 0) {
            this.aa--;
         }

         lv.c("keyboard");

         while (Keyboard.next()) {
            afu.a(Keyboard.getEventKey(), Keyboard.getEventKeyState());
            if (Keyboard.getEventKeyState()) {
               afu.a(Keyboard.getEventKey());
            }

            if (Keyboard.getEventKeyState()) {
               if (Keyboard.getEventKey() == 87) {
                  this.j();
               } else {
                  if (this.s != null) {
                     this.s.j();
                  } else {
                     if (Keyboard.getEventKey() == 1) {
                        this.i();
                     }

                     if (Keyboard.getEventKey() == 31 && Keyboard.isKeyDown(61)) {
                        this.A();
                     }

                     if (Keyboard.getEventKey() == 20 && Keyboard.isKeyDown(61)) {
                        this.p.b();
                     }

                     if (Keyboard.getEventKey() == 33 && Keyboard.isKeyDown(61)) {
                        boolean flag = Keyboard.isKeyDown(42) | Keyboard.isKeyDown(54);
                        this.A.a(zq.g, flag ? -1 : 1);
                     }

                     if (Keyboard.getEventKey() == 30 && Keyboard.isKeyDown(61)) {
                        this.g.a();
                     }

                     if (Keyboard.getEventKey() == 59) {
                        this.A.D = !this.A.D;
                     }

                     if (Keyboard.getEventKey() == 61) {
                        this.A.F = !this.A.F;
                        this.A.G = !vp.m();
                     }

                     if (Keyboard.getEventKey() == 63) {
                        this.A.E++;
                        if (this.A.E > 2) {
                           this.A.E = 0;
                        }
                     }

                     if (Keyboard.getEventKey() == 66) {
                        this.A.J = !this.A.J;
                     }
                  }

                  for (int i = 0; i < 9; i++) {
                     if (Keyboard.getEventKey() == 2 + i) {
                        this.h.ap.c = i;
                     }
                  }

                  if (this.A.F && this.A.G) {
                     if (Keyboard.getEventKey() == 11) {
                        this.b(0);
                     }

                     for (int j = 0; j < 9; j++) {
                        if (Keyboard.getEventKey() == 2 + j) {
                           this.b(j + 1);
                        }
                     }
                  }
               }
            }
         }

         while (this.A.s.c()) {
            this.a(new ain(this.h));
         }

         while (this.A.t.c()) {
            this.h.as();
         }

         while (this.A.u.c()) {
            this.a(new yf());
         }

         if (this.s == null && (Keyboard.isKeyDown(53) || Keyboard.isKeyDown(181))) {
            this.a(new yf("/"));
         }

         if (this.h.aj()) {
            if (!this.A.x.e) {
               this.c.c(this.h);
            }

            while (this.A.w.c()) {
            }

            while (this.A.x.c()) {
            }

            while (this.A.z.c()) {
            }
         } else {
            while (this.A.w.c()) {
               this.c(0);
            }

            while (this.A.x.c()) {
               this.c(1);
            }

            while (this.A.z.c()) {
               this.B();
            }
         }

         if (this.A.x.e && this.ae == 0 && !this.h.aj()) {
            this.c(1);
         }

         this.a(0, this.s == null && this.A.w.e && this.R);
      }

      if (this.f != null) {
         if (this.h != null) {
            this.al++;
            if (this.al == 30) {
               this.al = 0;
               this.f.g(this.h);
            }
         }

         if (this.f.B().s()) {
            this.f.q = 3;
         } else {
            this.f.q = this.A.C;
         }

         if (this.f.F) {
            this.f.q = 1;
         }

         lv.c("gameRenderer");
         if (!this.o) {
            this.u.a();
         }

         lv.c("levelRenderer");
         if (!this.o) {
            this.g.d();
         }

         lv.c("level");
         if (!this.o) {
            if (this.f.n > 0) {
               this.f.n--;
            }

            this.f.n();
         }

         if (!this.o || this.l()) {
            this.f.a(this.f.q > 0, true);
            this.f.c();
         }

         lv.c("animateTick");
         if (!this.o && this.f != null) {
            this.f.randomDisplayUpdates(gk.d(this.h.o), gk.c(this.h.p), gk.d(this.h.q));
         }

         lv.c("particles");
         if (!this.o) {
            this.j.a();
         }
      }

      lv.b();
      this.T = System.currentTimeMillis();
   }

   private void A() {
      System.out.println("FORCING RELOAD!");
      this.C = new sd();
      this.C.a(this.A);
      this.Y.a();
   }

   public boolean l() {
      return this.f != null && this.f.F;
   }

   public void a(String par1Str, String par2Str, fj par3WorldSettings) {
      this.a((xd)null);
      System.gc();
      if (this.ad.a(par1Str)) {
         this.b(par1Str, par2Str);
      } else {
         if (this.t != null) {
            this.t.a(cy.a("menu.switchingLevel"));
            this.t.d("");
         }

         akp isavehandler = this.ad.a(par1Str, false);
         xd world = null;
         world = new xd(isavehandler, par2Str, par3WorldSettings);
         if (world.s) {
            this.K.a(gv.g, 1);
            this.K.a(gv.f, 1);
            this.a(world, cy.a("menu.generatingLevel"));
         } else {
            this.K.a(gv.h, 1);
            this.K.a(gv.f, 1);
            this.a(world, cy.a("menu.loadingLevel"));
         }
      }
   }

   public void a(int par1) {
      int i = this.h.aB;
      this.h.aB = par1;
      this.f.b(this.h);
      this.h.G = false;
      double d = this.h.o;
      double d1 = this.h.q;
      double d2 = 1.0;
      if (i > -1 && this.h.aB == -1) {
         d2 = 0.125;
      } else if (i == -1 && this.h.aB > -1) {
         d2 = 8.0;
      }

      d *= d2;
      d1 *= d2;
      if (this.h.aB == -1) {
         this.h.c(d, this.h.p, d1, this.h.u, this.h.v);
         if (this.h.M()) {
            this.f.a(this.h, false);
         }

         xd world = null;
         world = new xd(this.f, alb.a(this.h.aB));
         this.a(world, "Entering the Nether", this.h);
      } else if (this.h.aB == 0) {
         if (this.h.M()) {
            this.h.c(d, this.h.p, d1, this.h.u, this.h.v);
            this.f.a(this.h, false);
         }

         xd world1 = null;
         world1 = new xd(this.f, alb.a(this.h.aB));
         if (i == -1) {
            this.a(world1, "Leaving the Nether", this.h);
         } else {
            this.a(world1, "Leaving the End", this.h);
         }
      } else {
         xd world2 = null;
         world2 = new xd(this.f, alb.a(this.h.aB));
         uh chunkcoordinates = world2.k();
         d = chunkcoordinates.a;
         this.h.p = chunkcoordinates.b;
         d1 = chunkcoordinates.c;
         this.h.c(d, this.h.p, d1, 90.0F, 0.0F);
         if (this.h.M()) {
            world2.a(this.h, false);
         }

         this.a(world2, "Entering the End", this.h);
      }

      this.h.k = this.f;
      System.out.println("Teleported to " + this.f.t.g);
      if (this.h.M() && i < 1) {
         this.h.c(d, this.h.p, d1, this.h.u, this.h.v);
         this.f.a(this.h, false);
         new ox().a(this.f, this.h);
      }
   }

   public void b(String par1Str) {
      this.f = null;
      this.a((xd)null, par1Str);
   }

   public void a(xd par1World) {
      this.a(par1World, "");
   }

   public void a(xd par1World, String par2Str) {
      this.a(par1World, par2Str, null);
   }

   public void a(xd par1World, String par2Str, yw par3EntityPlayer) {
      this.K.b();
      this.K.c();
      this.i = null;
      if (this.t != null) {
         this.t.a(par2Str);
         this.t.d("");
      }

      this.C.a(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      if (this.f != null) {
         this.f.a(this.t);
      }

      this.f = par1World;
      if (par1World != null) {
         if (this.c != null) {
            this.c.a(par1World);
         }

         if (!this.l()) {
            if (par3EntityPlayer == null) {
               this.h = (vq)par1World.a(vq.class);
            }
         } else if (this.h != null) {
            this.h.z();
            if (par1World != null) {
               par1World.a(this.h);
            }
         }

         if (!par1World.F) {
            this.e(par2Str);
         }

         if (this.h == null) {
            this.h = (vq)this.c.b(par1World);
            this.h.z();
            this.c.a(this.h);
         }

         this.h.a = new ij(this.A);
         if (this.g != null) {
            this.g.a(par1World);
         }

         if (this.j != null) {
            this.j.a(par1World);
         }

         if (par3EntityPlayer != null) {
            par1World.l();
         }

         ca ichunkprovider = par1World.z();
         if (ichunkprovider instanceof hy) {
            hy chunkproviderloadorgenerate = (hy)ichunkprovider;
            long i = gk.d(this.h.o) >> 4;
            long j = gk.d(this.h.q) >> 4;
            chunkproviderloadorgenerate.setCurrentChunkOver(i, j);
         }

         par1World.a(this.h);
         this.c.b(this.h);
         if (par1World.s) {
            par1World.a(this.t);
         }

         this.i = this.h;
      } else {
         this.ad.d();
         this.h = null;
      }

      System.gc();
      this.T = 0L;
   }

   private void b(String par1Str, String par2Str) {
      this.t.a("Converting World to " + this.ad.a());
      this.t.d("This may take a while :)");
      this.ad.a(par1Str, this.t);
      this.a(par1Str, par2Str, new fj(0L, 0, true, false, vx.b));
   }

   private void e(String par1Str) {
      if (this.t != null) {
         this.t.a(par1Str);
         this.t.d(cy.a("menu.generatingTerrain"));
      }

      char c = 128;
      long notchSucksDick = c;
      if (this.c.e()) {
         c = '@';
      }

      int i = 0;
      int j = c * 2 / 16 + 1;
      j *= j;
      ca ichunkprovider = this.f.z();
      uh chunkcoordinates = this.f.x();
      if (this.h != null) {
         chunkcoordinates.a = (long)this.h.o;
         chunkcoordinates.c = (long)this.h.q;
      }

      if (ichunkprovider instanceof hy) {
         hy chunkproviderloadorgenerate = (hy)ichunkprovider;
         chunkproviderloadorgenerate.setCurrentChunkOver(chunkcoordinates.a >> 4, chunkcoordinates.c >> 4);
      }

      for (long k = -c; k <= c; k += 16L) {
         for (long l = -c; l <= c; l += 16L) {
            if (this.t != null) {
               this.t.a(i++ * 100 / j);
            }

            this.f.getBlockId(chunkcoordinates.a + k, 64, chunkcoordinates.c + l);
            if (!this.c.e()) {
               while (this.f.H()) {
               }
            }
         }
      }

      if (!this.c.e()) {
         if (this.t != null) {
            this.t.d(cy.a("menu.simulating"));
         }

         char c1 = 2000;
         this.f.t();
      }
   }

   public void a(String par1Str, File par2File) {
      int i = par1Str.indexOf("/");
      String s = par1Str.substring(0, i);
      par1Str = par1Str.substring(i + 1);
      if (s.equalsIgnoreCase("sound")) {
         this.C.a(par1Str, par2File);
      } else if (s.equalsIgnoreCase("newsound")) {
         this.C.a(par1Str, par2File);
      } else if (s.equalsIgnoreCase("streaming")) {
         this.C.b(par1Str, par2File);
      } else if (s.equalsIgnoreCase("music")) {
         this.C.c(par1Str, par2File);
      } else if (s.equalsIgnoreCase("newmusic")) {
         this.C.c(par1Str, par2File);
      }
   }

   public String m() {
      return this.g.b();
   }

   public String n() {
      return this.g.c();
   }

   public String o() {
      return this.f.p();
   }

   public String p() {
      return "P: " + this.j.b() + ". T: " + this.f.o();
   }

   public void a(boolean par1, int par2, boolean par3) {
      if (!this.f.F && !this.f.t.d()) {
         this.a(0);
      }

      uh chunkcoordinates = null;
      uh chunkcoordinates1 = null;
      boolean flag = true;
      if (this.h != null && !par1) {
         chunkcoordinates = this.h.aC();
         if (chunkcoordinates != null) {
            chunkcoordinates1 = yw.a(this.f, chunkcoordinates);
            if (chunkcoordinates1 == null) {
               this.h.b("tile.bed.notValid");
            }
         }
      }

      if (chunkcoordinates1 == null) {
         chunkcoordinates1 = this.f.x();
         flag = false;
      }

      ca ichunkprovider = this.f.z();
      if (ichunkprovider instanceof hy) {
         hy chunkproviderloadorgenerate = (hy)ichunkprovider;
         chunkproviderloadorgenerate.setCurrentChunkOver(chunkcoordinates1.a >> 4, chunkcoordinates1.c >> 4);
      }

      this.f.e();
      this.f.y();
      int i = 0;
      if (this.h != null) {
         i = this.h.f;
         this.f.b(this.h);
      }

      vq entityplayersp = this.h;
      this.i = null;
      this.h = (vq)this.c.b(this.f);
      if (par3) {
         this.h.d(entityplayersp);
      }

      this.h.aB = par2;
      this.i = this.h;
      this.h.z();
      if (flag) {
         this.h.a(chunkcoordinates);
         this.h.c(chunkcoordinates1.a + 0.5, chunkcoordinates1.b + 0.1, chunkcoordinates1.c + 0.5, 0.0F, 0.0F);
      }

      this.c.a(this.h);
      this.f.a(this.h);
      this.h.a = new ij(this.A);
      this.h.f = i;
      this.h.ab();
      this.c.b(this.h);
      this.e(cy.a("menu.respawning"));
      if (this.s instanceof uy) {
         this.a((vp)null);
      }
   }

   public static void a(String par0Str, String par1Str) {
      a(par0Str, par1Str, (String)null);
   }

   public static void a(String par0Str, String par1Str, String par2Str) {
      boolean flag = false;
      String s = par0Str;
      Frame frame = new Frame("Minecraft \"64-bit Edition\" by Daniel \"314rft\" Ryan");
      Canvas canvas = new Canvas();
      frame.setLayout(new BorderLayout());
      frame.add(canvas, "Center");
      canvas.setPreferredSize(new Dimension(854, 480));
      frame.pack();
      frame.setLocationRelativeTo(null);
      hq minecraftimpl = new hq(frame, canvas, null, 854, 480, flag, frame);
      Thread thread = new Thread(minecraftimpl, "Minecraft main thread");
      thread.setPriority(10);
      minecraftimpl.l = "www.minecraft.net";
      if (s != null && par1Str != null) {
         minecraftimpl.k = new fc(s, par1Str);
      } else {
         minecraftimpl.k = new fc("Player" + System.currentTimeMillis() % 1000L, "");
      }

      if (par2Str != null) {
         String[] as = par2Str.split(":");
         minecraftimpl.a(as[0], Integer.parseInt(as[1]));
      }

      frame.setVisible(true);
      frame.addWindowListener(new hl(minecraftimpl, thread));
      thread.start();
   }

   public adl q() {
      return this.h instanceof ahv ? ((ahv)this.h).cl : null;
   }

   public static void main(String[] par0ArrayOfStr) {
      String s = null;
      String s1 = null;
      s = "Player" + System.currentTimeMillis() % 1000L;
      if (par0ArrayOfStr.length > 0) {
         s = par0ArrayOfStr[0];
      }

      s1 = "-";
      if (par0ArrayOfStr.length > 1) {
         s1 = par0ArrayOfStr[1];
      }

      a(s, s1);
   }

   public static boolean r() {
      return a == null || !a.A.D;
   }

   public static boolean s() {
      return a != null && a.A.j;
   }

   public static boolean t() {
      return a != null && a.A.k;
   }

   public static boolean u() {
      return a != null && a.A.F;
   }

   public boolean c(String par1Str) {
      if (!par1Str.startsWith("/")) {
      }

      return par1Str.startsWith("/");
   }

   private void B() {
      if (this.z != null) {
         boolean flag = this.h.aT.d;
         int i = this.f.getBlockId(this.z.b, this.z.c, this.z.d);
         if (!flag) {
            if (i == pb.u.bO) {
               i = pb.v.bO;
            }

            if (i == pb.aj.bO) {
               i = pb.ak.bO;
            }

            if (i == pb.z.bO) {
               i = pb.t.bO;
            }
         }

         int j = 0;
         boolean flag1 = false;
         if (yr.e[i] != null && yr.e[i].g()) {
            j = this.f.getBlockMetadata(this.z.b, this.z.c, this.z.d);
            flag1 = true;
         }

         if (yr.e[i] != null && yr.e[i] instanceof vd) {
            pb block = pb.m[i];
            int l = block.a(j, this.h.k.r, 0);
            if (l > 0) {
               i = l;
            }
         }

         this.h.ap.a(i, j, flag1, flag);
         if (flag) {
            int k = this.h.aq.e.size() - 9 + this.h.ap.c;
            this.c.a(this.h.ap.k_(this.h.ap.c), k);
         }
      }
   }

   public static String C() {
      return "1.2.5";
   }

   public static void D() {
      vt playerusagesnooper = new vt("client");
      playerusagesnooper.a("version", C());
      playerusagesnooper.a("os_name", System.getProperty("os.name"));
      playerusagesnooper.a("os_version", System.getProperty("os.version"));
      playerusagesnooper.a("os_architecture", System.getProperty("os.arch"));
      playerusagesnooper.a("memory_total", Runtime.getRuntime().totalMemory());
      playerusagesnooper.a("memory_max", Runtime.getRuntime().maxMemory());
      playerusagesnooper.a("java_version", System.getProperty("java.version"));
      playerusagesnooper.a("opengl_version", GL11.glGetString(7938));
      playerusagesnooper.a("opengl_vendor", GL11.glGetString(7936));
      playerusagesnooper.a();
   }
}
