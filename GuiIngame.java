import java.awt.Color;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class GuiIngame extends oo {
   private static tw d = new tw();
   private List e = new ArrayList();
   private List f = new ArrayList();
   private Random h = new Random();
   private Minecraft i;
   private int j = 0;
   private String k = "";
   private int l = 0;
   private boolean m = false;
   private int n = 0;
   private boolean o = false;
   public float b;
   float c = 1.0F;
   private DecimalFormat youreWelcomeMuzik;

   public GuiIngame(Minecraft par1Minecraft) {
      this.i = par1Minecraft;
      this.youreWelcomeMuzik = new DecimalFormat("#.####");
   }

   public void a(float par1, boolean par2, int par3, int par4) {
      agd scaledresolution = new agd(this.i.A, this.i.d, this.i.e);
      int i = scaledresolution.a();
      int j = scaledresolution.b();
      nl fontrenderer = this.i.q;
      this.i.u.b();
      GL11.glEnable(3042);
      if (Minecraft.s()) {
         this.a(this.i.h.a(par1), i, j);
      } else {
         GL11.glBlendFunc(770, 771);
      }

      ItemStack itemstack = this.i.h.ap.f(3);
      if (this.i.A.E == 0 && itemstack != null && itemstack.c == Block.ba.bO) {
         this.b(i, j);
      }

      if (!this.i.h.a(aad.k)) {
         float f = this.i.h.aS + (this.i.h.aR - this.i.h.aS) * par1;
         if (f > 0.0F) {
            this.b(f, i, j);
         }
      }

      if (!this.i.c.e()) {
         fontrenderer.a("Minecraft 1.2.5", 2, 2, 16777215);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         GL11.glBindTexture(3553, this.i.p.b("/gui/gui.png"));
         aak inventoryplayer = this.i.h.ap;
         this.g = -90.0F;
         this.b(i / 2 - 91, j - 22, 0, 0, 182, 22);
         this.b(i / 2 - 91 - 1 + inventoryplayer.c * 20, j - 22 - 1, 0, 22, 24, 22);
         GL11.glBindTexture(3553, this.i.p.b("/gui/icons.png"));
         GL11.glEnable(3042);
         GL11.glBlendFunc(775, 769);
         this.b(i / 2 - 7, j / 2 - 7, 0, 0, 16, 16);
         GL11.glDisable(3042);
         boolean flag = this.i.h.Y / 3 % 2 == 1;
         if (this.i.h.Y < 10) {
            flag = false;
         }

         int i1 = this.i.h.ItemBucket();
         int i2 = this.i.h.by;
         this.h.setSeed(this.j * 312871);
         boolean flag2 = false;
         ne foodstats = this.i.h.aF();
         int j4 = foodstats.a();
         int l4 = foodstats.b();
         this.f();
         if (this.i.c.d()) {
            int j5 = i / 2 - 91;
            int i6 = i / 2 + 91;
            int l6 = this.i.h.aE();
            if (l6 > 0) {
               char c = 182;
               int j8 = (int)(this.i.h.aW * (c + 1));
               int i9 = j - 32 + 3;
               this.b(j5, i9, 0, 64, c, 5);
               if (j8 > 0) {
                  this.b(j5, i9, 0, 69, j8, 5);
               }
            }

            int k7 = j - 39;
            int k8 = k7 - 10;
            int j9 = this.i.h.au();
            int i10 = -1;
            if (this.i.h.a(aad.l)) {
               i10 = this.j % 25;
            }

            for (int j10 = 0; j10 < 10; j10++) {
               if (j9 > 0) {
                  int i11 = j5 + j10 * 8;
                  if (j10 * 2 + 1 < j9) {
                     this.b(i11, k8, 34, 9, 9, 9);
                  }

                  if (j10 * 2 + 1 == j9) {
                     this.b(i11, k8, 25, 9, 9, 9);
                  }

                  if (j10 * 2 + 1 > j9) {
                     this.b(i11, k8, 16, 9, 9, 9);
                  }
               }

               int j11 = 16;
               if (this.i.h.a(aad.u)) {
                  j11 += 36;
               }

               int i12 = 0;
               if (flag) {
                  i12 = 1;
               }

               int l12 = j5 + j10 * 8;
               int j13 = k7;
               if (i1 <= 4) {
                  j13 += this.h.nextInt(2);
               }

               if (j10 == i10) {
                  j13 -= 2;
               }

               byte byte3 = 0;
               if (this.i.f.B().s()) {
                  byte3 = 5;
               }

               this.b(l12, j13, 16 + i12 * 9, 9 * byte3, 9, 9);
               if (flag) {
                  if (j10 * 2 + 1 < i2) {
                     this.b(l12, j13, j11 + 54, 9 * byte3, 9, 9);
                  }

                  if (j10 * 2 + 1 == i2) {
                     this.b(l12, j13, j11 + 63, 9 * byte3, 9, 9);
                  }
               }

               if (j10 * 2 + 1 < i1) {
                  this.b(l12, j13, j11 + 36, 9 * byte3, 9, 9);
               }

               if (j10 * 2 + 1 == i1) {
                  this.b(l12, j13, j11 + 45, 9 * byte3, 9, 9);
               }
            }

            for (int k10 = 0; k10 < 10; k10++) {
               int k11 = k7;
               int j12 = 16;
               byte byte2 = 0;
               if (this.i.h.a(aad.s)) {
                  j12 += 36;
                  byte2 = 13;
               }

               if (this.i.h.aF().d() <= 0.0F && this.j % (j4 * 3 + 1) == 0) {
                  k11 += this.h.nextInt(3) - 1;
               }

               if (flag2) {
                  byte2 = 1;
               }

               int k13 = i6 - k10 * 8 - 9;
               this.b(k13, k11, 16 + byte2 * 9, 27, 9, 9);
               if (flag2) {
                  if (k10 * 2 + 1 < l4) {
                     this.b(k13, k11, j12 + 54, 27, 9, 9);
                  }

                  if (k10 * 2 + 1 == l4) {
                     this.b(k13, k11, j12 + 63, 27, 9, 9);
                  }
               }

               if (k10 * 2 + 1 < j4) {
                  this.b(k13, k11, j12 + 36, 27, 9, 9);
               }

               if (k10 * 2 + 1 == j4) {
                  this.b(k13, k11, j12 + 45, 27, 9, 9);
               }
            }

            if (this.i.h.a(acn.g)) {
               int l10 = this.i.h.Y();
               int l11 = (int)Math.ceil((l10 - 2) * 10.0 / 300.0);
               int k12 = (int)Math.ceil(l10 * 10.0 / 300.0) - l11;

               for (int i13 = 0; i13 < l11 + k12; i13++) {
                  if (i13 < l11) {
                     this.b(i6 - i13 * 8 - 9, k8, 16, 18, 9, 9);
                  } else {
                     this.b(i6 - i13 * 8 - 9, k8, 25, 18, 9, 9);
                  }
               }
            }
         }

         GL11.glDisable(3042);
         GL11.glEnable(32826);
         tf.c();

         for (int k5 = 0; k5 < 9; k5++) {
            int j6 = i / 2 - 90 + k5 * 20 + 2;
            int i7 = j - 16 - 3;
            this.a(k5, j6, i7, par1);
         }

         tf.a();
         GL11.glDisable(32826);
      }

      if (this.i.h.aB() > 0) {
         GL11.glDisable(2929);
         GL11.glDisable(3008);
         int k = this.i.h.aB();
         float f1 = k / 100.0F;
         if (f1 > 1.0F) {
            f1 = 1.0F - (k - 100) / 10.0F;
         }

         int j1 = (int)(220.0F * f1) << 24 | 1052704;
         a(0, 0, i, j, j1);
         GL11.glEnable(3008);
         GL11.glEnable(2929);
      }

      if (this.i.c.f() && this.i.h.aU > 0) {
         boolean flag1 = false;
         int k1 = flag1 ? 16777215 : 8453920;
         String s = "" + this.i.h.aU;
         int i3 = (i - fontrenderer.a(s)) / 2;
         int k3 = j - 31 - 4;
         fontrenderer.b(s, i3 + 1, k3, 0);
         fontrenderer.b(s, i3 - 1, k3, 0);
         fontrenderer.b(s, i3, k3 + 1, 0);
         fontrenderer.b(s, i3, k3 - 1, 0);
         fontrenderer.b(s, i3, k3, k1);
      }

      if (this.i.A.F) {
         GL11.glPushMatrix();
         if (Minecraft.J > 0L) {
            GL11.glTranslatef(0.0F, 32.0F, 0.0F);
         }

         fontrenderer.a("Minecraft 1.2.5 (" + this.i.M + ")", 2, 2, 16777215);
         fontrenderer.a(this.i.m(), 2, 12, 16777215);
         fontrenderer.a(this.i.n(), 2, 22, 16777215);
         fontrenderer.a(this.i.p(), 2, 32, 16777215);
         fontrenderer.a(this.i.o(), 2, 42, 16777215);
         long l = Runtime.getRuntime().maxMemory();
         long l2 = Runtime.getRuntime().totalMemory();
         long l3 = Runtime.getRuntime().freeMemory();
         long l5 = l2 - l3;
         String s1 = "Used memory: " + l5 * 100L / l + "% (" + l5 / 1024L / 1024L + "MB) of " + l / 1024L / 1024L + "MB";
         this.b(fontrenderer, s1, i - fontrenderer.a(s1) - 2, 2, 14737632);
         s1 = "Allocated memory: " + l2 * 100L / l + "% (" + l2 / 1024L / 1024L + "MB)";
         this.b(fontrenderer, s1, i - fontrenderer.a(s1) - 2, 12, 14737632);
         this.b(fontrenderer, "x: " + this.youreWelcomeMuzik.format(this.i.h.o), 2, 64, 14737632);
         this.b(fontrenderer, "y: " + this.youreWelcomeMuzik.format(this.i.h.p), 2, 72, 14737632);
         this.b(fontrenderer, "z: " + this.youreWelcomeMuzik.format(this.i.h.q), 2, 80, 14737632);
         this.b(fontrenderer, "f: " + (MathHelper.c(this.i.h.u * 4.0F / 360.0F + 0.5) & 3), 2, 88, 14737632);
         long l7 = MathHelper.d(this.i.h.o);
         int l8 = MathHelper.c(this.i.h.p);
         long k9 = MathHelper.d(this.i.h.q);
         if (this.i.f != null && this.i.f.blockExists(l7, l8, k9)) {
            Chunk chunk = this.i.f.getChunkFromBlockCoords(l7, k9);
            this.b(
               fontrenderer,
               "lc: "
                  + (chunk.h() + 15)
                  + " b: "
                  + chunk.a((int)(l7 & 15L), (int)(k9 & 15L), this.i.f.i()).y
                  + " bl: "
                  + chunk.a(wl.b, (int)(l7 & 15L), l8, (int)(k9 & 15L))
                  + " sl: "
                  + chunk.a(wl.a, (int)(l7 & 15L), l8, (int)(k9 & 15L))
                  + " rl: "
                  + chunk.c((int)(l7 & 15L), l8, (int)(k9 & 15L), 0),
               2,
               96,
               14737632
            );
         }

         if (!this.i.f.F) {
            this.b(fontrenderer, "Seed: " + this.i.f.v(), 2, 112, 14737632);
         }

         GL11.glPopMatrix();
      }

      if (this.l > 0) {
         float f2 = this.l - par1;
         int l1 = (int)(f2 * 256.0F / 20.0F);
         if (l1 > 255) {
            l1 = 255;
         }

         if (l1 > 0) {
            GL11.glPushMatrix();
            GL11.glTranslatef(i / 2, j - 48, 0.0F);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            int j2 = 16777215;
            if (this.m) {
               j2 = Color.HSBtoRGB(f2 / 50.0F, 0.7F, 0.6F) & 16777215;
            }

            fontrenderer.b(this.k, -fontrenderer.a(this.k) / 2, -4, j2 + (l1 << 24));
            GL11.glDisable(3042);
            GL11.glPopMatrix();
         }
      }

      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      GL11.glDisable(3008);
      GL11.glPushMatrix();
      GL11.glTranslatef(0.0F, j - 48, 0.0F);
      this.a(fontrenderer);
      GL11.glPopMatrix();
      if (this.i.h instanceof EntityClientPlayerMP && this.i.A.y.e) {
         NetClientHandler netclienthandler = ((EntityClientPlayerMP)this.i.h).cl;
         List list = netclienthandler.c;
         int k2 = netclienthandler.d;
         int j3 = k2;

         int i4;
         for (i4 = 1; j3 > 20; j3 = (k2 + i4 - 1) / i4) {
            i4++;
         }

         int k4 = 300 / i4;
         if (k4 > 150) {
            k4 = 150;
         }

         int i5 = (i - i4 * k4) / 2;
         byte byte0 = 10;
         a(i5 - 1, byte0 - 1, i5 + k4 * i4, byte0 + 9 * j3, Integer.MIN_VALUE);

         for (int k6 = 0; k6 < k2; k6++) {
            int j7 = i5 + k6 % i4 * k4;
            int i8 = byte0 + k6 / i4 * 9;
            a(j7, i8, j7 + k4 - 1, i8 + 8, 553648127);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glEnable(3008);
            if (k6 < list.size()) {
               ah guiplayerinfo = (ah)list.get(k6);
               fontrenderer.a(guiplayerinfo.a, j7, i8, 16777215);
               this.i.p.b(this.i.p.b("/gui/icons.png"));
               int l9 = 0;
               byte byte1 = 0;
               if (guiplayerinfo.b < 0) {
                  byte1 = 5;
               } else if (guiplayerinfo.b < 150) {
                  byte1 = 0;
               } else if (guiplayerinfo.b < 300) {
                  byte1 = 1;
               } else if (guiplayerinfo.b < 600) {
                  byte1 = 2;
               } else if (guiplayerinfo.b < 1000) {
                  byte1 = 3;
               } else {
                  byte1 = 4;
               }

               this.g += 100.0F;
               this.b(j7 + k4 - 12, i8, 0 + l9 * 10, 176 + byte1 * 8, 10, 8);
               this.g -= 100.0F;
            }
         }
      }

      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glDisable(2896);
      GL11.glEnable(3008);
   }

   private void a(nl par1FontRenderer) {
      byte byte0 = 10;
      boolean flag = false;
      int i = 0;
      int j = this.e.size();
      if (j > 0) {
         if (this.e()) {
            byte0 = 20;
            flag = true;
         }

         for (int k = 0; k + this.n < this.e.size() && k < byte0; k++) {
            if (((nt)this.e.get(k)).b < 200 || flag) {
               nt chatline = (nt)this.e.get(k + this.n);
               double d = chatline.b / 200.0;
               d = 1.0 - d;
               d *= 10.0;
               if (d < 0.0) {
                  d = 0.0;
               }

               if (d > 1.0) {
                  d = 1.0;
               }

               d *= d;
               int l1 = (int)(255.0 * d);
               if (flag) {
                  l1 = 255;
               }

               i++;
               if (l1 > 2) {
                  byte byte1 = 3;
                  int j2 = -k * 9;
                  String s = chatline.a;
                  a(byte1, j2 - 1, byte1 + 320 + 4, j2 + 8, l1 / 2 << 24);
                  GL11.glEnable(3042);
                  par1FontRenderer.a(s, byte1, j2, 16777215 + (l1 << 24));
               }
            }
         }

         if (flag) {
            GL11.glTranslatef(0.0F, par1FontRenderer.b, 0.0F);
            int l = j * par1FontRenderer.b + j;
            int i1 = i * par1FontRenderer.b + i;
            int j1 = this.n * i1 / j;
            int k1 = i1 * i1 / l;
            if (l != i1) {
               char c = (char)(j1 <= 0 ? 96 : 170);
               int i2 = this.o ? 13382451 : 3355562;
               a(0, -j1, 2, -j1 - k1, i2 + (c << 24));
               a(2, -j1, 1, -j1 - k1, 13421772 + (c << 24));
            }
         }
      }
   }

   private void f() {
      if (or.c != null) {
         EntityDragon entitydragon = or.c;
         or.c = null;
         nl fontrenderer = this.i.q;
         agd scaledresolution = new agd(this.i.A, this.i.d, this.i.e);
         int i = scaledresolution.a();
         char c = 182;
         int j = i / 2 - c / 2;
         int k = (int)((float)entitydragon.x() / entitydragon.d() * (c + 1));
         byte byte0 = 12;
         this.b(j, byte0, 0, 74, c, 5);
         this.b(j, byte0, 0, 74, c, 5);
         if (k > 0) {
            this.b(j, byte0, 0, 79, k, 5);
         }

         String s = "Boss health";
         fontrenderer.a(s, i / 2 - fontrenderer.a(s) / 2, byte0 - 10, 16711935);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         GL11.glBindTexture(3553, this.i.p.b("/gui/icons.png"));
      }
   }

   private void b(int par1, int par2) {
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glBlendFunc(770, 771);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glDisable(3008);
      GL11.glBindTexture(3553, this.i.p.b("%blur%/misc/pumpkinblur.png"));
      Tessellator tessellator = Tessellator.a;
      tessellator.b();
      tessellator.a(0.0, par2, -90.0, 0.0, 1.0);
      tessellator.a(par1, par2, -90.0, 1.0, 1.0);
      tessellator.a(par1, 0.0, -90.0, 1.0, 0.0);
      tessellator.a(0.0, 0.0, -90.0, 0.0, 0.0);
      tessellator.a();
      GL11.glDepthMask(true);
      GL11.glEnable(2929);
      GL11.glEnable(3008);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   private void a(float par1, int par2, int par3) {
      par1 = 1.0F - par1;
      if (par1 < 0.0F) {
         par1 = 0.0F;
      }

      if (par1 > 1.0F) {
         par1 = 1.0F;
      }

      this.c = (float)(this.c + (par1 - this.c) * 0.01);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glBlendFunc(0, 769);
      GL11.glColor4f(this.c, this.c, this.c, 1.0F);
      GL11.glBindTexture(3553, this.i.p.b("%blur%/misc/vignette.png"));
      Tessellator tessellator = Tessellator.a;
      tessellator.b();
      tessellator.a(0.0, par3, -90.0, 0.0, 1.0);
      tessellator.a(par2, par3, -90.0, 1.0, 1.0);
      tessellator.a(par2, 0.0, -90.0, 1.0, 0.0);
      tessellator.a(0.0, 0.0, -90.0, 0.0, 0.0);
      tessellator.a();
      GL11.glDepthMask(true);
      GL11.glEnable(2929);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glBlendFunc(770, 771);
   }

   private void b(float par1, int par2, int par3) {
      if (par1 < 1.0F) {
         par1 *= par1;
         par1 *= par1;
         par1 = par1 * 0.8F + 0.2F;
      }

      GL11.glDisable(3008);
      GL11.glDisable(2929);
      GL11.glDepthMask(false);
      GL11.glBlendFunc(770, 771);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, par1);
      GL11.glBindTexture(3553, this.i.p.b("/terrain.png"));
      float f = Block.be.bN % 16 / 16.0F;
      float f1 = Block.be.bN / 16 / 16.0F;
      float f2 = (Block.be.bN % 16 + 1) / 16.0F;
      float f3 = (Block.be.bN / 16 + 1) / 16.0F;
      Tessellator tessellator = Tessellator.a;
      tessellator.b();
      tessellator.a(0.0, par3, -90.0, f, f3);
      tessellator.a(par2, par3, -90.0, f2, f3);
      tessellator.a(par2, 0.0, -90.0, f2, f1);
      tessellator.a(0.0, 0.0, -90.0, f, f1);
      tessellator.a();
      GL11.glDepthMask(true);
      GL11.glEnable(2929);
      GL11.glEnable(3008);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
   }

   private void a(int par1, int par2, int par3, float par4) {
      ItemStack itemstack = this.i.h.ap.a[par1];
      if (itemstack != null) {
         float f = itemstack.b - par4;
         if (f > 0.0F) {
            GL11.glPushMatrix();
            float f1 = 1.0F + f / 5.0F;
            GL11.glTranslatef(par2 + 8, par3 + 12, 0.0F);
            GL11.glScalef(1.0F / f1, (f1 + 1.0F) / 2.0F, 1.0F);
            GL11.glTranslatef(-(par2 + 8), -(par3 + 12), 0.0F);
         }

         d.a(this.i.q, this.i.p, itemstack, par2, par3);
         if (f > 0.0F) {
            GL11.glPopMatrix();
         }

         d.b(this.i.q, this.i.p, itemstack, par2, par3);
      }
   }

   public void a() {
      if (this.l > 0) {
         this.l--;
      }

      this.j++;

      for (int i = 0; i < this.e.size(); i++) {
         ((nt)this.e.get(i)).b++;
      }
   }

   public void b() {
      this.e.clear();
      this.f.clear();
   }

   public void a(String par1Str) {
      boolean flag = this.e();
      boolean flag1 = true;

      for (String s : this.i.q.c(par1Str, 320)) {
         if (flag && this.n > 0) {
            this.o = true;
            this.a(1);
         }

         if (!flag1) {
            s = " " + s;
         }

         flag1 = false;
         this.e.add(0, new nt(s));
      }

      while (this.e.size() > 100) {
         this.e.remove(this.e.size() - 1);
      }
   }

   public void addChatMessageInternal(String par1Str) {
      boolean flag = this.e();
      boolean flag1 = true;

      for (String s : this.i.q.c(par1Str, 320)) {
         if (flag && this.n > 0) {
            this.o = true;
            this.a(1);
         }

         if (!flag1) {
            s = " " + s;
         }

         flag1 = false;
         this.f.add(s);
      }

      while (this.f.size() > 100) {
         this.f.remove(this.f.size() - 1);
      }
   }

   public List c() {
      return this.f;
   }

   public void d() {
      this.n = 0;
      this.o = false;
   }

   public void a(int par1) {
      this.n += par1;
      int i = this.e.size();
      if (this.n > i - 20) {
         this.n = i - 20;
      }

      if (this.n <= 0) {
         this.n = 0;
         this.o = false;
      }
   }

   public void func_50011_aDupe(int par1) {
      this.n += par1;
      int i = this.f.size();
      if (this.n > i - 20) {
         this.n = i - 20;
      }

      if (this.n <= 0) {
         this.n = 0;
         this.o = false;
      }
   }

   public dx a(int par1, int par2) {
      if (!this.e()) {
         return null;
      }

      agd scaledresolution = new agd(this.i.A, this.i.d, this.i.e);
      par2 = par2 / scaledresolution.c - 40;
      par1 = par1 / scaledresolution.c - 3;
      if (par1 >= 0 && par2 >= 0) {
         int i = Math.min(20, this.e.size());
         if (par1 <= 320 && par2 < this.i.q.b * i + i) {
            int j = par2 / (this.i.q.b + 1) + this.n;
            return new dx(this.i.q, (nt)this.e.get(j), par1, par2 - (j - this.n) * this.i.q.b + j);
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   public void b(String par1Str) {
      this.k = "Now playing: " + par1Str;
      this.l = 60;
      this.m = true;
   }

   public boolean e() {
      return this.i.s instanceof GuiChat;
   }

   public void c(String par1Str) {
      adn stringtranslate = adn.a();
      String s = stringtranslate.b(par1Str);
      this.a(s);
   }
}
