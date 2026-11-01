import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

public class GameSettings {
   private static final String[] S = new String[]{
      "options.renderDistance.far", "options.renderDistance.normal", "options.renderDistance.short", "options.renderDistance.tiny"
   };
   private static final String[] T = new String[]{
      "options.difficulty.peaceful", "options.difficulty.easy", "options.difficulty.normal", "options.difficulty.hard"
   };
   private static final String[] U = new String[]{"options.guiScale.auto", "options.guiScale.small", "options.guiScale.normal", "options.guiScale.large"};
   private static final String[] V = new String[]{"options.particles.EntitySquid", "options.particles.decreased", "options.particles.minimal"};
   private static final String[] W = new String[]{"performance.max", "performance.balanced", "performance.powersaver"};
   public float a = 1.0F;
   public float b = 1.0F;
   public float c = 0.5F;
   public boolean d = false;
   public int e = 0;
   public boolean f = true;
   public boolean g = false;
   public boolean h = false;
   public int i = 1;
   public boolean j = true;
   public boolean k = true;
   public boolean l = true;
   public String m = "Default";
   public afu n = new afu("key.forward", 17);
   public afu o = new afu("key.left", 30);
   public afu p = new afu("key.back", 31);
   public afu q = new afu("key.right", 32);
   public afu r = new afu("key.jump", 57);
   public afu s = new afu("key.inventory", 18);
   public afu t = new afu("key.drop", 16);
   public afu u = new afu("key.chat", 20);
   public afu v = new afu("key.sneak", 42);
   public afu w = new afu("key.attack", -100);
   public afu x = new afu("key.use", -99);
   public afu y = new afu("key.playerlist", 15);
   public afu z = new afu("key.pickItem", -98);
   public afu[] A = new afu[]{this.w, this.x, this.n, this.o, this.p, this.q, this.r, this.v, this.t, this.s, this.u, this.y, this.z};
   protected Minecraft B;
   private File X;
   public int C = 2;
   public boolean D = false;
   public int E = 0;
   public boolean F = false;
   public boolean G = false;
   public String H = "";
   public boolean I = false;
   public boolean J = false;
   public boolean K = false;
   public float L = 1.0F;
   public float M = 1.0F;
   public float N = 0.0F;
   public float O = 0.0F;
   public int P = 0;
   public int Q = 0;
   public String R = "en_US";
   public boolean stripeLandsFix = false;

   public GameSettings(Minecraft par1Minecraft, File par2File) {
      this.B = par1Minecraft;
      this.X = new File(par2File, "optionsMod.txt");
      this.a();
   }

   public GameSettings() {
   }

   public String a(int par1) {
      adn stringtranslate = adn.a();
      return stringtranslate.b(this.A[par1].c);
   }

   public String b(int par1) {
      int i = this.A[par1].d;
      return c(i);
   }

   public static String c(int par0) {
      return par0 < 0 ? cy.a("key.mouseButton", new Object[]{par0 + 101}) : Keyboard.getKeyName(par0);
   }

   public void a(int par1, int par2) {
      this.A[par1].d = par2;
      this.b();
   }

   public void a(EnumOptions par1EnumOptions, float par2) {
      if (par1EnumOptions == EnumOptions.a) {
         this.a = par2;
         this.B.C.a();
      }

      if (par1EnumOptions == EnumOptions.b) {
         this.b = par2;
         this.B.C.a();
      }

      if (par1EnumOptions == EnumOptions.d) {
         this.c = par2;
      }

      if (par1EnumOptions == EnumOptions.e) {
         this.N = par2;
      }

      if (par1EnumOptions == EnumOptions.f) {
         this.O = par2;
      }
   }

   public void a(EnumOptions par1EnumOptions, int par2) {
      if (par1EnumOptions == EnumOptions.c) {
         this.d = !this.d;
      }

      if (par1EnumOptions == EnumOptions.g) {
         this.e = this.e + par2 & 3;
      }

      if (par1EnumOptions == EnumOptions.o) {
         this.P = this.P + par2 & 3;
      }

      if (par1EnumOptions == EnumOptions.q) {
         this.Q = (this.Q + par2) % 3;
      }

      if (par1EnumOptions == EnumOptions.h) {
         this.f = !this.f;
      }

      if (par1EnumOptions == EnumOptions.p) {
         this.l = !this.l;
      }

      if (par1EnumOptions == EnumOptions.j) {
         this.h = !this.h;
         this.B.g.a();
      }

      if (par1EnumOptions == EnumOptions.i) {
         this.g = !this.g;
         this.B.p.b();
      }

      if (par1EnumOptions == EnumOptions.k) {
         this.i = (this.i + par2 + 3) % 3;
      }

      if (par1EnumOptions == EnumOptions.l) {
         this.C = this.C + par2 & 3;
      }

      if (par1EnumOptions == EnumOptions.m) {
         this.j = !this.j;
         this.B.g.a();
      }

      if (par1EnumOptions == EnumOptions.n) {
         this.k = !this.k;
         this.B.g.a();
      }

      if (par1EnumOptions == EnumOptions.STRIPELANDSFIX) {
         this.stripeLandsFix = !this.stripeLandsFix;
         this.B.g.a();
      }

      this.b();
   }

   public float a(EnumOptions par1EnumOptions) {
      if (par1EnumOptions == EnumOptions.e) {
         return this.N;
      } else if (par1EnumOptions == EnumOptions.f) {
         return this.O;
      } else if (par1EnumOptions == EnumOptions.a) {
         return this.a;
      } else if (par1EnumOptions == EnumOptions.b) {
         return this.b;
      } else {
         return par1EnumOptions == EnumOptions.d ? this.c : 0.0F;
      }
   }

   public boolean b(EnumOptions par1EnumOptions) {
      switch (EnumOptionsMappingHelper.a[par1EnumOptions.ordinal()]) {
         case 1:
            return this.d;
         case 2:
            return this.f;
         case 3:
            return this.g;
         case 4:
            return this.h;
         case 5:
            return this.k;
         case 6:
            return this.l;
         case 7:
            return this.stripeLandsFix;
         default:
            return false;
      }
   }

   private static String a(String[] par0ArrayOfStr, int par1) {
      if (par1 < 0 || par1 >= par0ArrayOfStr.length) {
         par1 = 0;
      }

      adn stringtranslate = adn.a();
      return stringtranslate.b(par0ArrayOfStr[par1]);
   }

   public String c(EnumOptions par1EnumOptions) {
      adn stringtranslate = adn.a();
      String s = stringtranslate.b(par1EnumOptions.d()) + ": ";
      if (par1EnumOptions.a()) {
         float f = this.a(par1EnumOptions);
         if (par1EnumOptions == EnumOptions.d) {
            if (f == 0.0F) {
               return s + stringtranslate.b("options.sensitivity.min");
            } else {
               return f == 1.0F ? s + stringtranslate.b("options.sensitivity.max") : s + (int)(f * 200.0F) + "%";
            }
         } else if (par1EnumOptions == EnumOptions.e) {
            if (f == 0.0F) {
               return s + stringtranslate.b("options.fov.min");
            } else {
               return f == 1.0F ? s + stringtranslate.b("options.fov.max") : s + (int)(70.0F + f * 40.0F);
            }
         } else if (par1EnumOptions == EnumOptions.f) {
            if (f == 0.0F) {
               return s + stringtranslate.b("options.gamma.min");
            } else {
               return f == 1.0F ? s + stringtranslate.b("options.gamma.max") : s + "+" + (int)(f * 100.0F) + "%";
            }
         } else {
            return f == 0.0F ? s + stringtranslate.b("options.off") : s + (int)(f * 100.0F) + "%";
         }
      } else if (par1EnumOptions.b()) {
         boolean flag = this.b(par1EnumOptions);
         return flag ? s + stringtranslate.b("options.on") : s + stringtranslate.b("options.off");
      } else if (par1EnumOptions == EnumOptions.g) {
         return s + a(S, this.e);
      } else if (par1EnumOptions == EnumOptions.l) {
         return s + a(T, this.C);
      } else if (par1EnumOptions == EnumOptions.o) {
         return s + a(U, this.P);
      } else if (par1EnumOptions == EnumOptions.q) {
         return s + a(V, this.Q);
      } else if (par1EnumOptions == EnumOptions.k) {
         return s + a(W, this.i);
      } else if (par1EnumOptions == EnumOptions.m) {
         return this.j ? s + stringtranslate.b("options.graphics.fancy") : s + stringtranslate.b("options.graphics.fast");
      } else {
         return s;
      }
   }

   public void a() {
      try {
         if (!this.X.exists()) {
            return;
         }

         BufferedReader bufferedreader = new BufferedReader(new FileReader(this.X));
         String s = "";

         while ((s = bufferedreader.readLine()) != null) {
            try {
               String[] as = s.split(":");
               if (as[0].equals("music")) {
                  this.a = this.a(as[1]);
               }

               if (as[0].equals("sound")) {
                  this.b = this.a(as[1]);
               }

               if (as[0].equals("mouseSensitivity")) {
                  this.c = this.a(as[1]);
               }

               if (as[0].equals("fov")) {
                  this.N = this.a(as[1]);
               }

               if (as[0].equals("gamma")) {
                  this.O = this.a(as[1]);
               }

               if (as[0].equals("invertYMouse")) {
                  this.d = as[1].equals("true");
               }

               if (as[0].equals("viewDistance")) {
                  this.e = Integer.parseInt(as[1]);
               }

               if (as[0].equals("guiScale")) {
                  this.P = Integer.parseInt(as[1]);
               }

               if (as[0].equals("particles")) {
                  this.Q = Integer.parseInt(as[1]);
               }

               if (as[0].equals("bobView")) {
                  this.f = as[1].equals("true");
               }

               if (as[0].equals("anaglyph3d")) {
                  this.g = as[1].equals("true");
               }

               if (as[0].equals("advancedOpengl")) {
                  this.h = as[1].equals("true");
               }

               if (as[0].equals("fpsLimit")) {
                  this.i = Integer.parseInt(as[1]);
               }

               if (as[0].equals("difficulty")) {
                  this.C = Integer.parseInt(as[1]);
               }

               if (as[0].equals("fancyGraphics")) {
                  this.j = as[1].equals("true");
               }

               if (as[0].equals("GenLayerHills")) {
                  this.k = as[1].equals("true");
               }

               if (as[0].equals("clouds")) {
                  this.l = as[1].equals("true");
               }

               if (as[0].equals("stripeLandsFix")) {
                  this.stripeLandsFix = as[1].equals("true");
               }

               if (as[0].equals("skin")) {
                  this.m = as[1];
               }

               if (as[0].equals("lastServer") && as.length >= 2) {
                  this.H = as[1];
               }

               if (as[0].equals("lang") && as.length >= 2) {
                  this.R = as[1];
               }

               for (int i = 0; i < this.A.length; i++) {
                  if (as[0].equals("key_" + this.A[i].c)) {
                     this.A[i].d = Integer.parseInt(as[1]);
                  }
               }
            } catch (Exception exception1) {
               System.out.println("Skipping bad option: " + s);
            }
         }

         afu.b();
         bufferedreader.close();
      } catch (Exception exception) {
         System.out.println("Failed WorldGenTallGrass load options");
         exception.printStackTrace();
      }
   }

   private float a(String par1Str) {
      if (par1Str.equals("true")) {
         return 1.0F;
      } else {
         return par1Str.equals("false") ? 0.0F : Float.parseFloat(par1Str);
      }
   }

   public void b() {
      try {
         PrintWriter printwriter = new PrintWriter(new FileWriter(this.X));
         printwriter.println("music:" + this.a);
         printwriter.println("sound:" + this.b);
         printwriter.println("invertYMouse:" + this.d);
         printwriter.println("mouseSensitivity:" + this.c);
         printwriter.println("fov:" + this.N);
         printwriter.println("gamma:" + this.O);
         printwriter.println("viewDistance:" + this.e);
         printwriter.println("guiScale:" + this.P);
         printwriter.println("particles:" + this.Q);
         printwriter.println("bobView:" + this.f);
         printwriter.println("anaglyph3d:" + this.g);
         printwriter.println("advancedOpengl:" + this.h);
         printwriter.println("fpsLimit:" + this.i);
         printwriter.println("difficulty:" + this.C);
         printwriter.println("fancyGraphics:" + this.j);
         printwriter.println("GenLayerHills:" + this.k);
         printwriter.println("clouds:" + this.l);
         printwriter.println("stripeLandsFix:" + this.stripeLandsFix);
         printwriter.println("skin:" + this.m);
         printwriter.println("lastServer:" + this.H);
         printwriter.println("lang:" + this.R);

         for (int i = 0; i < this.A.length; i++) {
            printwriter.println("key_" + this.A[i].c + ":" + this.A[i].d);
         }

         printwriter.close();
      } catch (Exception exception) {
         System.out.println("Failed WorldGenTallGrass save options");
         exception.printStackTrace();
      }
   }

   public boolean c() {
      return this.l;
   }
}
