import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.List;
import java.util.Random;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.util.glu.GLU;

public class EntityRenderer {
   public static boolean a = false;
   public static int b;
   private Minecraft r;
   private float s = 0.0F;
   public ItemRenderer c;
   private int t;
   private Entity u = null;
   private ch v = new ch();
   private ch w = new ch();
   private ch x = new ch();
   private ch y = new ch();
   private ch z = new ch();
   private ch A = new ch();
   private float B = 4.0F;
   private float C = 4.0F;
   private float D = 0.0F;
   private float E = 0.0F;
   private float F = 0.0F;
   private float G = 0.0F;
   private float H;
   private float I;
   private float J;
   private float K;
   private float L;
   private float M = 0.0F;
   private float N = 0.0F;
   private float O = 0.0F;
   private float P = 0.0F;
   public int d;
   private int[] Q;
   private float R;
   private float S;
   private float T;
   private boolean U = false;
   private double V = 1.0;
   private double W = 0.0;
   private double X = 0.0;
   private long Y = System.currentTimeMillis();
   private long Z = 0L;
   private boolean BlockSnowBlock = false;
   float e = 0.0F;
   float f = 0.0F;
   float g = 0.0F;
   float h = 0.0F;
   private Random ab = new Random();
   private int EntityNoteFX = 0;
   float[] i;
   float[] j;
   volatile int k = 0;
   volatile int l = 0;
   FloatBuffer m = GLAllocation.e(16);
   float n;
   float o;
   float p;
   private float ad;
   private float BlockTNT;
   public int q;

   public EntityRenderer(Minecraft par1Minecraft) {
      this.r = par1Minecraft;
      this.c = new ItemRenderer(par1Minecraft);
      this.d = par1Minecraft.p.a(new BufferedImage(16, 16, 1));
      this.Q = new int[256];
   }

   public void a() {
      this.c();
      this.d();
      this.ad = this.BlockTNT;
      this.C = this.B;
      this.E = this.D;
      this.G = this.F;
      this.N = this.M;
      this.P = this.O;
      if (this.r.A.J) {
         float f = this.r.A.c * 0.6F + 0.2F;
         float f2 = f * f * f * 8.0F;
         this.J = this.v.a(this.H, 0.05F * f2);
         this.K = this.w.a(this.I, 0.05F * f2);
         this.L = 0.0F;
         this.H = 0.0F;
         this.I = 0.0F;
      }

      if (this.r.i == null) {
         this.r.i = this.r.h;
      }

      float f1 = this.r.f.getLightBrightness(MathHelper.d(this.r.i.o), MathHelper.c(this.r.i.p), MathHelper.d(this.r.i.q));
      float f3 = (3 - this.r.A.e) / 3.0F;
      float f4 = f1 * (1.0F - f3) + f3;
      this.BlockTNT = this.BlockTNT + (f4 - this.BlockTNT) * 0.1F;
      this.t++;
      this.c.a();
      this.f();
   }

   public void a(float par1) {
      if (this.r.i != null) {
         if (this.r.f != null) {
            double d = this.r.c.b();
            this.r.z = this.r.i.a(d, par1);
            double d1 = d;
            bo vec3d = this.r.i.j(par1);
            if (this.r.c.i()) {
               d = 6.0;
               d1 = 6.0;
            } else {
               if (d1 > 3.0) {
                  d1 = 3.0;
               }

               d = d1;
            }

            if (this.r.z != null) {
               d1 = this.r.z.f.d(vec3d);
            }

            bo vec3d1 = this.r.i.k(par1);
            bo vec3d2 = vec3d.c(vec3d1.a * d, vec3d1.b * d, vec3d1.c * d);
            this.u = null;
            float f = 1.0F;
            List list = this.r.f.b(this.r.i, this.r.i.y.a(vec3d1.a * d, vec3d1.b * d, vec3d1.c * d).b(f, f, f));
            double d2 = d1;

            for (int i = 0; i < list.size(); i++) {
               Entity entity = (Entity)list.get(i);
               if (entity.l_()) {
                  float f1 = entity.j_();
                  AxisAlignedBB axisalignedbb = entity.y.b(f1, f1, f1);
                  MovingObjectPosition movingobjectposition = axisalignedbb.a(vec3d, vec3d2);
                  if (axisalignedbb.a(vec3d)) {
                     if (0.0 < d2 || d2 == 0.0) {
                        this.u = entity;
                        d2 = 0.0;
                     }
                  } else if (movingobjectposition != null) {
                     double d3 = vec3d.d(movingobjectposition.f);
                     if (d3 < d2 || d2 == 0.0) {
                        this.u = entity;
                        d2 = d3;
                     }
                  }
               }
            }

            if (this.u != null && (d2 < d1 || this.r.z == null)) {
               this.r.z = new MovingObjectPosition(this.u);
            }
         }
      }
   }

   private void c() {
      EntityPlayerSP entityplayersp = (EntityPlayerSP)this.r.i;
      this.T = entityplayersp.I_();
      this.S = this.R;
      this.R = this.R + (this.T - this.R) * 0.5F;
   }

   private float a(float par1, boolean par2) {
      if (this.q > 0) {
         return 90.0F;
      }

      EntityPlayer entityplayer = (EntityPlayer)this.r.i;
      float f = 70.0F;
      if (par2) {
         f += this.r.A.N * 40.0F;
         f *= this.S + (this.R - this.S) * par1;
      }

      if (entityplayer.ItemBucket() <= 0) {
         float f1 = entityplayer.bD + par1;
         f /= (1.0F - 500.0F / (f1 + 500.0F)) * 2.0F + 1.0F;
      }

      int i = ActiveRenderInfo.a(this.r.f, entityplayer, par1);
      if (i != 0 && Block.m[i].cd == acn.g) {
         f = f * 60.0F / 70.0F;
      }

      return f + this.N + (this.M - this.N) * par1;
   }

   private void d(float par1) {
      EntityLiving entityliving = this.r.i;
      float f = entityliving.bA - par1;
      if (entityliving.ItemBucket() <= 0) {
         float f1 = entityliving.bD + par1;
         GL11.glRotatef(40.0F - 8000.0F / (f1 + 200.0F), 0.0F, 0.0F, 1.0F);
      }

      if (!(f < 0.0F)) {
         f /= entityliving.bB;
         f = MathHelper.a(f * f * f * f * (float) Math.PI);
         float f2 = entityliving.bC;
         GL11.glRotatef(-f2, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(-f * 14.0F, 0.0F, 0.0F, 1.0F);
         GL11.glRotatef(f2, 0.0F, 1.0F, 0.0F);
      }
   }

   private void e(float par1) {
      if (this.r.i instanceof EntityPlayer) {
         EntityPlayer entityplayer = (EntityPlayer)this.r.i;
         float f = entityplayer.L - entityplayer.K;
         float f1 = -(entityplayer.L + f * par1);
         float f2 = entityplayer.aw + (entityplayer.EntityAIAttackOnCollide - entityplayer.aw) * par1;
         float f3 = entityplayer.bF + (entityplayer.bG - entityplayer.bF) * par1;
         GL11.glTranslatef(MathHelper.a(f1 * (float) Math.PI) * f2 * 0.5F, -Math.abs(MathHelper.b(f1 * (float) Math.PI) * f2), 0.0F);
         GL11.glRotatef(MathHelper.a(f1 * (float) Math.PI) * f2 * 3.0F, 0.0F, 0.0F, 1.0F);
         GL11.glRotatef(Math.abs(MathHelper.b(f1 * (float) Math.PI - 0.2F) * f2) * 5.0F, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(f3, 1.0F, 0.0F, 0.0F);
      }
   }

   private void f(float par1) {
      EntityLiving entityliving = this.r.i;
      float f = entityliving.H - 1.62F;
      double d = entityliving.l + (entityliving.o - entityliving.l) * par1;
      double d1 = entityliving.m + (entityliving.p - entityliving.m) * par1 - f;
      double d2 = entityliving.n + (entityliving.q - entityliving.n) * par1;
      GL11.glRotatef(this.P + (this.O - this.P) * par1, 0.0F, 0.0F, 1.0F);
      if (entityliving.TileEntityDispenser()) {
         f = (float)(f + 1.0);
         GL11.glTranslatef(0.0F, 0.3F, 0.0F);
         if (!this.r.A.K) {
            int i = this.r.f.getBlockId(MathHelper.d(entityliving.o), MathHelper.c(entityliving.p), MathHelper.d(entityliving.q));
            if (i == Block.S.bO) {
               int j = this.r.f.getBlockMetadata(MathHelper.d(entityliving.o), MathHelper.c(entityliving.p), MathHelper.d(entityliving.q));
               int k = j & 3;
               GL11.glRotatef(k * 90, 0.0F, 1.0F, 0.0F);
            }

            GL11.glRotatef(entityliving.w + (entityliving.u - entityliving.w) * par1 + 180.0F, 0.0F, -1.0F, 0.0F);
            GL11.glRotatef(entityliving.x + (entityliving.v - entityliving.x) * par1, -1.0F, 0.0F, 0.0F);
         }
      } else if (this.r.A.E > 0) {
         double d3 = this.C + (this.B - this.C) * par1;
         if (this.r.A.K) {
            float f1 = this.E + (this.D - this.E) * par1;
            float f3 = this.G + (this.F - this.G) * par1;
            GL11.glTranslatef(0.0F, 0.0F, (float)(-d3));
            GL11.glRotatef(f3, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(f1, 0.0F, 1.0F, 0.0F);
         } else {
            float f2 = entityliving.u;
            float f4 = entityliving.v;
            if (this.r.A.E == 2) {
               f4 += 180.0F;
            }

            double d4 = -MathHelper.a(f2 / 180.0F * (float) Math.PI) * MathHelper.b(f4 / 180.0F * (float) Math.PI) * d3;
            double d5 = MathHelper.b(f2 / 180.0F * (float) Math.PI) * MathHelper.b(f4 / 180.0F * (float) Math.PI) * d3;
            double d6 = -MathHelper.a(f4 / 180.0F * (float) Math.PI) * d3;

            for (int l = 0; l < 8; l++) {
               float f5 = (l & 1) * 2 - 1;
               float f6 = (l >> 1 & 1) * 2 - 1;
               float f7 = (l >> 2 & 1) * 2 - 1;
               f5 *= 0.1F;
               f6 *= 0.1F;
               f7 *= 0.1F;
               MovingObjectPosition movingobjectposition = this.r.f.a(bo.b(d + f5, d1 + f6, d2 + f7), bo.b(d - d4 + f5 + f7, d1 - d6 + f6, d2 - d5 + f7));
               if (movingobjectposition != null) {
                  double d7 = movingobjectposition.f.d(bo.b(d, d1, d2));
                  if (d7 < d3) {
                     d3 = d7;
                  }
               }
            }

            if (this.r.A.E == 2) {
               GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
            }

            GL11.glRotatef(entityliving.v - f4, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(entityliving.u - f2, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(0.0F, 0.0F, (float)(-d3));
            GL11.glRotatef(f2 - entityliving.u, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(f4 - entityliving.v, 1.0F, 0.0F, 0.0F);
         }
      } else {
         GL11.glTranslatef(0.0F, 0.0F, -0.1F);
      }

      if (!this.r.A.K) {
         GL11.glRotatef(entityliving.x + (entityliving.v - entityliving.x) * par1, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(entityliving.w + (entityliving.u - entityliving.w) * par1 + 180.0F, 0.0F, 1.0F, 0.0F);
      }

      GL11.glTranslatef(0.0F, f, 0.0F);
      d = entityliving.l + (entityliving.o - entityliving.l) * par1;
      d1 = entityliving.m + (entityliving.p - entityliving.m) * par1 - f;
      d2 = entityliving.n + (entityliving.q - entityliving.n) * par1;
      this.U = this.r.g.a(d, d1, d2, par1);
   }

   private void a(float par1, int par2) {
      this.s = 512 >> this.r.A.e;
      GL11.glMatrixMode(5889);
      GL11.glLoadIdentity();
      float f = 0.07F;
      if (this.r.A.g) {
         GL11.glTranslatef(-(par2 * 2 - 1) * f, 0.0F, 0.0F);
      }

      if (this.V != 1.0) {
         GL11.glTranslatef((float)this.W, (float)(-this.X), 0.0F);
         GL11.glScaled(this.V, this.V, 1.0);
      }

      GLU.gluPerspective(this.a(par1, true), (float)this.r.d / this.r.e, 0.05F, this.s * 2.0F);
      if (this.r.c.e()) {
         float f1 = 0.6666667F;
         GL11.glScalef(1.0F, f1, 1.0F);
      }

      GL11.glMatrixMode(5888);
      GL11.glLoadIdentity();
      if (this.r.A.g) {
         GL11.glTranslatef((par2 * 2 - 1) * 0.1F, 0.0F, 0.0F);
      }

      this.d(par1);
      if (this.r.A.f) {
         this.e(par1);
      }

      float f2 = this.r.h.aS + (this.r.h.aR - this.r.h.aS) * par1;
      if (f2 > 0.0F) {
         int i = 20;
         if (this.r.h.a(aad.k)) {
            i = 7;
         }

         float f3 = 5.0F / (f2 * f2 + 5.0F) - f2 * 0.04F;
         f3 *= f3;
         GL11.glRotatef((this.t + par1) * i, 0.0F, 1.0F, 1.0F);
         GL11.glScalef(1.0F / f3, 1.0F, 1.0F);
         GL11.glRotatef(-(this.t + par1) * i, 0.0F, 1.0F, 1.0F);
      }

      this.f(par1);
      if (this.q > 0) {
         int j = this.q - 1;
         if (j == 1) {
            GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
         }

         if (j == 2) {
            GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
         }

         if (j == 3) {
            GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
         }

         if (j == 4) {
            GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
         }

         if (j == 5) {
            GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
         }
      }
   }

   private void b(float par1, int par2) {
      if (this.q <= 0) {
         GL11.glMatrixMode(5889);
         GL11.glLoadIdentity();
         float f = 0.07F;
         if (this.r.A.g) {
            GL11.glTranslatef(-(par2 * 2 - 1) * f, 0.0F, 0.0F);
         }

         if (this.V != 1.0) {
            GL11.glTranslatef((float)this.W, (float)(-this.X), 0.0F);
            GL11.glScaled(this.V, this.V, 1.0);
         }

         GLU.gluPerspective(this.a(par1, false), (float)this.r.d / this.r.e, 0.05F, this.s * 2.0F);
         if (this.r.c.e()) {
            float f1 = 0.6666667F;
            GL11.glScalef(1.0F, f1, 1.0F);
         }

         GL11.glMatrixMode(5888);
         GL11.glLoadIdentity();
         if (this.r.A.g) {
            GL11.glTranslatef((par2 * 2 - 1) * 0.1F, 0.0F, 0.0F);
         }

         GL11.glPushMatrix();
         this.d(par1);
         if (this.r.A.f) {
            this.e(par1);
         }

         if (this.r.A.E == 0 && !this.r.i.TileEntityDispenser() && !this.r.A.D && !this.r.c.e()) {
            this.b((double)par1);
            this.c.a(par1);
            this.a((double)par1);
         }

         GL11.glPopMatrix();
         if (this.r.A.E == 0 && !this.r.i.TileEntityDispenser()) {
            this.c.b(par1);
            this.d(par1);
         }

         if (this.r.A.f) {
            this.e(par1);
         }
      }
   }

   public void a(double par1) {
      es.a(es.b);
      GL11.glDisable(3553);
      es.a(es.a);
   }

   public void b(double par1) {
      es.a(es.b);
      GL11.glMatrixMode(5890);
      GL11.glLoadIdentity();
      float f = 0.00390625F;
      GL11.glScalef(f, f, f);
      GL11.glTranslatef(8.0F, 8.0F, 8.0F);
      GL11.glMatrixMode(5888);
      this.r.p.b(this.d);
      GL11.glTexParameteri(3553, 10241, 9729);
      GL11.glTexParameteri(3553, 10240, 9729);
      GL11.glTexParameteri(3553, 10241, 9729);
      GL11.glTexParameteri(3553, 10240, 9729);
      GL11.glTexParameteri(3553, 10242, 10496);
      GL11.glTexParameteri(3553, 10243, 10496);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glEnable(3553);
      es.a(es.a);
   }

   private void d() {
      if (this.r.A.k) {
         this.f = (float)(this.f + (Math.random() - Math.random()) * Math.random() * Math.random());
         this.h = (float)(this.h + (Math.random() - Math.random()) * Math.random() * Math.random());
         this.f = (float)(this.f * 0.9);
         this.h = (float)(this.h * 0.9);
         this.e = this.e + (this.f - this.e) * 1.0F;
         this.g = this.g + (this.h - this.g) * 1.0F;
      } else {
         this.e = 0.0F;
         this.f = 0.0F;
         this.g = 0.0F;
         this.h = 0.0F;
      }

      this.BlockSnowBlock = true;
   }

   private void e() {
      World world = this.r.f;
      if (world != null) {
         for (int i = 0; i < 256; i++) {
            float f = world.b(1.0F) * 0.95F + 0.05F;
            float f1 = world.t.f[i / 16] * f;
            float f2 = world.t.f[i % 16] * (this.e * 0.1F + 1.5F);
            if (world.n > 0) {
               f1 = world.t.f[i / 16];
            }

            float f3 = f1 * (world.b(1.0F) * 0.65F + 0.35F);
            float f4 = f1 * (world.b(1.0F) * 0.65F + 0.35F);
            float f5 = f1;
            float f6 = f2;
            float f7 = f2 * ((f2 * 0.6F + 0.4F) * 0.6F + 0.4F);
            float f8 = f2 * (f2 * f2 * 0.6F + 0.4F);
            double f9 = f3 + f6;
            double f10 = f4 + f7;
            double f11 = f5 + f8;
            f9 = f9 * 0.96 + 0.03;
            f10 = f10 * 0.96 + 0.03;
            f11 = f11 * 0.96 + 0.03;
            if (world.t.g == 1) {
               f9 = 0.22F + f6 * 0.75F;
               f10 = 0.28F + f7 * 0.75F;
               f11 = 0.25F + f8 * 0.75F;
            }

            double f12 = this.r.A.O;
            if (f9 > 1.0) {
               f9 = 1.0;
            }

            if (f10 > 1.0) {
               f10 = 1.0;
            }

            if (f11 > 1.0) {
               f11 = 1.0;
            }

            double f13 = 1.0 - f9;
            double f14 = 1.0 - f10;
            double f15 = 1.0 - f11;
            f13 = 1.0 - f13 * f13 * f13 * f13;
            f14 = 1.0 - f14 * f14 * f14 * f14;
            f15 = 1.0 - f15 * f15 * f15 * f15;
            f9 = f9 * (1.0 - f12) + f13 * f12;
            f10 = f10 * (1.0 - f12) + f14 * f12;
            f11 = f11 * (1.0 - f12) + f15 * f12;
            f9 = f9 * 0.96 + 0.03;
            f10 = f10 * 0.96 + 0.03;
            f11 = f11 * 0.96 + 0.03;
            if (f9 > 1.0) {
               f9 = 1.0;
            }

            if (f10 > 1.0) {
               f10 = 1.0;
            }

            if (f11 > 1.0) {
               f11 = 1.0;
            }

            if (f9 < 0.0) {
               f9 = 0.0;
            }

            if (f10 < 0.0) {
               f10 = 0.0;
            }

            if (f11 < 0.0) {
               f11 = 0.0;
            }

            char c = 255;
            int j = (int)(f9 * 255.0);
            int k = (int)(f10 * 255.0);
            int l = (int)(f11 * 255.0);
            this.Q[i] = c << 24 | j << 16 | k << 8 | l;
         }

         this.r.p.a(this.Q, 16, 16, this.d);
      }
   }

   public void b(float par1) {
      lv.a("lightTex");
      if (this.BlockSnowBlock) {
         this.e();
      }

      lv.b();
      if (!Display.isActive()) {
         if (System.currentTimeMillis() - this.Y > 500L) {
            this.r.i();
         }
      } else {
         this.Y = System.currentTimeMillis();
      }

      lv.a("mouse");
      if (this.r.R) {
         this.r.D.c();
         float f = this.r.A.c * 0.6F + 0.2F;
         float f1 = f * f * f * 8.0F;
         float f2 = this.r.D.a * f1;
         float f3 = this.r.D.b * f1;
         int l = 1;
         if (this.r.A.d) {
            l = -1;
         }

         if (this.r.A.J) {
            this.H += f2;
            this.I += f3;
            float f4 = par1 - this.L;
            this.L = par1;
            f2 = this.J * f4;
            f3 = this.K * f4;
            this.r.h.c(f2, f3 * l);
         } else {
            this.r.h.c(f2, f3 * l);
         }
      }

      lv.b();
      if (!this.r.x) {
         a = this.r.A.g;
         agd scaledresolution = new agd(this.r.A, this.r.d, this.r.e);
         int i = scaledresolution.a();
         int j = scaledresolution.b();
         int k = Mouse.getX() * i / this.r.d;
         int i1 = j - Mouse.getY() * j / this.r.e - 1;
         char c = 200;
         if (this.r.A.i == 1) {
            c = 'x';
         }

         if (this.r.A.i == 2) {
            c = '(';
         }

         if (this.r.f != null) {
            lv.a("level");
            if (this.r.A.i == 0) {
               this.a(par1, 0L);
            } else {
               this.a(par1, this.Z + 1000000000 / c);
            }

            lv.c("sleep");
            if (this.r.A.i == 2) {
               long l1 = (this.Z + 1000000000 / c - System.nanoTime()) / 1000000L;
               if (l1 > 0L && l1 < 500L) {
                  try {
                     Thread.sleep(l1);
                  } catch (InterruptedException interruptedexception) {
                     interruptedexception.printStackTrace();
                  }
               }
            }

            this.Z = System.nanoTime();
            lv.c("gui");
            if (!this.r.A.D || this.r.s != null) {
               this.r.w.a(par1, this.r.s != null, k, i1);
            }

            lv.b();
         } else {
            GL11.glViewport(0, 0, this.r.d, this.r.e);
            GL11.glMatrixMode(5889);
            GL11.glLoadIdentity();
            GL11.glMatrixMode(5888);
            GL11.glLoadIdentity();
            this.b();
            long l2 = (this.Z + 1000000000 / c - System.nanoTime()) / 1000000L;
            if (l2 < 0L) {
               l2 += 10L;
            }

            if (l2 > 0L && l2 < 500L) {
               try {
                  Thread.sleep(l2);
               } catch (InterruptedException interruptedexception1) {
                  interruptedexception1.printStackTrace();
               }
            }

            this.Z = System.nanoTime();
         }

         if (this.r.s != null) {
            GL11.glClear(256);
            this.r.s.a(k, i1, par1);
            if (this.r.s != null && this.r.s.v != null) {
               this.r.s.v.a(par1);
            }
         }
      }
   }

   public void a(float par1, long par2) {
      lv.a("lightTex");
      if (this.BlockSnowBlock) {
         this.e();
      }

      GL11.glEnable(2884);
      GL11.glEnable(2929);
      if (this.r.i == null) {
         this.r.i = this.r.h;
      }

      lv.c("pick");
      this.a(par1);
      EntityLiving entityliving = this.r.i;
      l renderglobal = this.r.g;
      EffectRenderer effectrenderer = this.r.j;
      double d = entityliving.N + (entityliving.o - entityliving.N) * par1;
      double d1 = entityliving.O + (entityliving.p - entityliving.O) * par1;
      double d2 = entityliving.P + (entityliving.q - entityliving.P) * par1;
      lv.c("center");
      IChunkProvider ichunkprovider = this.r.f.z();
      if (ichunkprovider instanceof ChunkProviderLoadOrGenerate) {
         ChunkProviderLoadOrGenerate chunkproviderloadorgenerate = (ChunkProviderLoadOrGenerate)ichunkprovider;
         long j = MathHelper.d(d) >> 4;
         long k = MathHelper.d(d2) >> 4;
         chunkproviderloadorgenerate.setCurrentChunkOver(j, k);
      }

      for (int i = 0; i < 2; i++) {
         if (this.r.A.g) {
            b = i;
            if (b == 0) {
               GL11.glColorMask(false, true, true, false);
            } else {
               GL11.glColorMask(true, false, false, false);
            }
         }

         lv.c("clear");
         GL11.glViewport(0, 0, this.r.d, this.r.e);
         this.g(par1);
         GL11.glClear(16640);
         GL11.glEnable(2884);
         lv.c("camera");
         this.a(par1, i);
         ActiveRenderInfo.a(this.r.h, this.r.A.E == 2);
         lv.c("frustrum");
         r.a();
         if (this.r.A.e < 2) {
            this.a(-1, par1);
            lv.c("sky");
            renderglobal.a(par1);
         }

         GL11.glEnable(2912);
         this.a(1, par1);
         if (this.r.A.k) {
            GL11.glShadeModel(7425);
         }

         lv.c("culling");
         nq frustrum = new nq();
         frustrum.a(d, d1, d2);
         this.r.g.a(frustrum, par1);
         if (i == 0) {
            lv.c("updatechunks");

            while (!this.r.g.a(entityliving, false) && par2 != 0L) {
               long l = par2 - System.nanoTime();
               if (l < 0L || l > 1000000000L) {
                  break;
               }
            }
         }

         this.a(0, par1);
         GL11.glEnable(2912);
         GL11.glBindTexture(3553, this.r.p.b("/terrain.png"));
         tf.a();
         lv.c("terrain");
         renderglobal.a(entityliving, 0, par1);
         GL11.glShadeModel(7424);
         if (this.q == 0) {
            tf.b();
            lv.c("entities");
            renderglobal.a(entityliving.j(par1), frustrum, par1);
            this.b((double)par1);
            lv.c("litParticles");
            effectrenderer.b(entityliving, par1);
            tf.a();
            this.a(0, par1);
            lv.c("particles");
            effectrenderer.a(entityliving, par1);
            this.a((double)par1);
            if (this.r.z != null && entityliving.a(acn.g) && entityliving instanceof EntityPlayer && !this.r.A.D) {
               EntityPlayer entityplayer = (EntityPlayer)entityliving;
               GL11.glDisable(3008);
               lv.c("outline");
               renderglobal.a(entityplayer, this.r.z, 0, entityplayer.ap.b(), par1);
               renderglobal.b(entityplayer, this.r.z, 0, entityplayer.ap.b(), par1);
               GL11.glEnable(3008);
            }
         }

         GL11.glDisable(3042);
         GL11.glEnable(2884);
         GL11.glBlendFunc(770, 771);
         GL11.glDepthMask(true);
         this.a(0, par1);
         GL11.glEnable(3042);
         GL11.glDisable(2884);
         GL11.glBindTexture(3553, this.r.p.b("/terrain.png"));
         if (this.r.A.j) {
            lv.c("water");
            if (this.r.A.k) {
               GL11.glShadeModel(7425);
            }

            GL11.glColorMask(false, false, false, false);
            int i1 = renderglobal.a(entityliving, 1, par1);
            if (this.r.A.g) {
               if (b == 0) {
                  GL11.glColorMask(false, true, true, true);
               } else {
                  GL11.glColorMask(true, false, false, true);
               }
            } else {
               GL11.glColorMask(true, true, true, true);
            }

            if (i1 > 0) {
               renderglobal.a(1, par1);
            }

            GL11.glShadeModel(7424);
         } else {
            lv.c("water");
            renderglobal.a(entityliving, 1, par1);
         }

         GL11.glDepthMask(true);
         GL11.glEnable(2884);
         GL11.glDisable(3042);
         if (this.V == 1.0 && entityliving instanceof EntityPlayer && !this.r.A.D && this.r.z != null && !entityliving.a(acn.g)) {
            EntityPlayer entityplayer1 = (EntityPlayer)entityliving;
            GL11.glDisable(3008);
            lv.c("outline");
            renderglobal.a(entityplayer1, this.r.z, 0, entityplayer1.ap.b(), par1);
            renderglobal.b(entityplayer1, this.r.z, 0, entityplayer1.ap.b(), par1);
            GL11.glEnable(3008);
         }

         lv.c("weather");
         this.c(par1);
         GL11.glDisable(2912);
         if (this.u == null) {
         }

         if (this.r.A.c()) {
            lv.c("clouds");
            GL11.glPushMatrix();
            this.a(0, par1);
            GL11.glEnable(2912);
            renderglobal.b(par1);
            GL11.glDisable(2912);
            this.a(1, par1);
            GL11.glPopMatrix();
         }

         lv.c("hand");
         if (this.V == 1.0) {
            GL11.glClear(256);
            this.b(par1, i);
         }

         if (!this.r.A.g) {
            lv.b();
            return;
         }
      }

      GL11.glColorMask(true, true, true, false);
      lv.b();
   }

   private void f() {
      float f = this.r.f.j(1.0F);
      if (!this.r.A.j) {
         f /= 2.0F;
      }

      if (f != 0.0F) {
         this.ab.setSeed(this.t * 312987231L);
         EntityLiving entityliving = this.r.i;
         World world = this.r.f;
         long i = MathHelper.d(entityliving.o);
         int j = MathHelper.c(entityliving.p);
         long k = MathHelper.d(entityliving.q);
         byte byte0 = 10;
         double d = 0.0;
         double d1 = 0.0;
         double d2 = 0.0;
         int l = 0;
         int i1 = (int)(100.0F * f * f);
         if (this.r.A.Q == 1) {
            i1 >>= 1;
         } else if (this.r.A.Q == 2) {
            i1 = 0;
         }

         for (int j1 = 0; j1 < i1; j1++) {
            long k1 = i + this.ab.nextInt(byte0) - this.ab.nextInt(byte0);
            long l1 = k + this.ab.nextInt(byte0) - this.ab.nextInt(byte0);
            int i2 = world.getPrecipitationHeight(k1, l1);
            int j2 = world.getBlockId(k1, i2 - 1, l1);
            BiomeGenBase biomegenbase = world.getBiomeGenForCoords(k1, l1);
            if (i2 <= j + byte0 && i2 >= j - byte0 && biomegenbase.d() && !(biomegenbase.j() <= 0.2F)) {
               double f1 = this.ab.nextFloat();
               double f2 = this.ab.nextFloat();
               if (j2 > 0) {
                  if (Block.m[j2].cd == acn.h) {
                     this.r.j.a(new EntitySmokeFX(world, k1 + f1, i2 + 0.1 - Block.m[j2].bW, l1 + f2, 0.0, 0.0, 0.0));
                  } else {
                     if (this.ab.nextInt(++l) == 0) {
                        d = k1 + f1;
                        d1 = i2 + 0.1 - Block.m[j2].bW;
                        d2 = l1 + f2;
                     }

                     this.r.j.a(new EntityRainFX(world, k1 + f1, i2 + 0.1 - Block.m[j2].bW, l1 + f2));
                  }
               }
            }
         }

         if (l > 0 && this.ab.nextInt(3) < this.EntityNoteFX++) {
            this.EntityNoteFX = 0;
            if (d1 > entityliving.p + 1.0 && world.getPrecipitationHeight(MathHelper.d(entityliving.o), MathHelper.d(entityliving.q)) > MathHelper.c(entityliving.p)) {
               this.r.f.a(d, d1, d2, "ambient.weather.rain", 0.1F, 0.5F);
            } else {
               this.r.f.a(d, d1, d2, "ambient.weather.rain", 0.2F, 1.0F);
            }
         }
      }
   }

   protected void c(float par1) {
      float f = this.r.f.j(par1);
      if (!(f <= 0.0F)) {
         this.b((double)par1);
         if (this.i == null) {
            this.i = new float[1024];
            this.j = new float[1024];

            for (int i = 0; i < 32; i++) {
               for (int j = 0; j < 32; j++) {
                  float f1 = j - 16;
                  float f2 = i - 16;
                  float f3 = MathHelper.c(f1 * f1 + f2 * f2);
                  this.i[i << 5 | j] = -f2 / f3;
                  this.j[i << 5 | j] = f1 / f3;
               }
            }
         }

         EntityLiving entityliving = this.r.i;
         World world = this.r.f;
         long k = MathHelper.d(entityliving.o);
         int l = MathHelper.c(entityliving.p);
         long i1 = MathHelper.d(entityliving.q);
         Tessellator tessellator = Tessellator.a;
         GL11.glDisable(2884);
         GL11.glNormal3f(0.0F, 1.0F, 0.0F);
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 771);
         GL11.glAlphaFunc(516, 0.01F);
         GL11.glBindTexture(3553, this.r.p.b("/environment/snow.png"));
         double d = entityliving.N + (entityliving.o - entityliving.N) * par1;
         double d1 = entityliving.O + (entityliving.p - entityliving.O) * par1;
         double d2 = entityliving.P + (entityliving.q - entityliving.P) * par1;
         int j1 = MathHelper.c(d1);
         int k1 = 5;
         if (this.r.A.j) {
            k1 = 10;
         }

         boolean flag = false;
         byte byte0 = -1;
         double f4 = (double)this.t + par1;
         if (this.r.A.j) {
            k1 = 10;
         }

         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         flag = false;

         for (long l1 = i1 - k1; l1 <= i1 + k1; l1++) {
            for (long i2 = k - k1; i2 <= k + k1; i2++) {
               int j2 = ((int)(l1 - i1) + 16) * 32 + (int)(i2 - k) + 16;
               double f5 = this.i[j2] * 0.5;
               double f6 = this.j[j2] * 0.5;
               BiomeGenBase biomegenbase = world.getBiomeGenForCoords(i2, l1);
               if (biomegenbase.d() || biomegenbase.c()) {
                  int k2 = world.getPrecipitationHeight(i2, l1);
                  int l2 = l - k1;
                  int i3 = l + k1;
                  if (l2 < k2) {
                     l2 = k2;
                  }

                  if (i3 < k2) {
                     i3 = k2;
                  }

                  float f7 = 1.0F;
                  int j3 = k2;
                  if (j3 < j1) {
                     j3 = j1;
                  }

                  if (l2 != i3) {
                     this.ab.setSeed(i2 * i2 * 3121L + i2 * 45238971L ^ l1 * l1 * 418711L + l1 * 13761L);
                     float f8 = biomegenbase.j();
                     if (world.i().a(f8, k2) >= 0.15F) {
                        if (byte0 != 0) {
                           if (byte0 >= 0) {
                              tessellator.a();
                           }

                           byte0 = 0;
                           GL11.glBindTexture(3553, this.r.p.b("/environment/rain.png"));
                           tessellator.b();
                        }

                        double f9 = ((double)(this.t + i2 * i2 * 3121L + i2 * 45238971L + l1 * l1 * 418711L + l1 * 13761L & 31L) + par1)
                           / 32.0
                           * (3.0 + this.ab.nextDouble());
                        double d3 = i2 + 0.5 - entityliving.o;
                        double d4 = l1 + 0.5 - entityliving.q;
                        float f13 = MathHelper.a(d3 * d3 + d4 * d4) / k1;
                        float f14 = 1.0F;
                        tessellator.b(world.getLightBrightnessForSkyBlocks(i2, j3, l1, 0));
                        tessellator.a(f14, f14, f14, ((1.0F - f13 * f13) * 0.5F + 0.5F) * f);
                        tessellator.b(-d * 1.0, -d1 * 1.0, -d2 * 1.0);
                        tessellator.a(i2 - f5 + 0.5, l2, l1 - f6 + 0.5, 0.0, l2 / 4.0 + f9);
                        tessellator.a(i2 + f5 + 0.5, l2, l1 + f6 + 0.5, 1.0, l2 / 4.0 + f9);
                        tessellator.a(i2 + f5 + 0.5, i3, l1 + f6 + 0.5, 1.0, i3 / 4.0 + f9);
                        tessellator.a(i2 - f5 + 0.5, i3, l1 - f6 + 0.5, 0.0, i3 / 4.0 + f9);
                        tessellator.b(0.0, 0.0, 0.0);
                     } else {
                        if (byte0 != 1) {
                           if (byte0 >= 0) {
                              tessellator.a();
                           }

                           byte0 = 1;
                           GL11.glBindTexture(3553, this.r.p.b("/environment/snow.png"));
                           tessellator.b();
                        }

                        double f10 = ((double)(this.t & 511) + par1) / 512.0;
                        double f11 = this.ab.nextDouble() + f4 * 0.01 * this.ab.nextGaussian();
                        double f12 = this.ab.nextDouble() + f4 * this.ab.nextGaussian() * 0.001;
                        double d5 = i2 + 0.5 - entityliving.o;
                        double d6 = l1 + 0.5 - entityliving.q;
                        float f15 = MathHelper.a(d5 * d5 + d6 * d6) / k1;
                        float f16 = 1.0F;
                        tessellator.b((world.getLightBrightnessForSkyBlocks(i2, j3, l1, 0) * 3 + 15728880) / 4);
                        tessellator.a(f16, f16, f16, ((1.0F - f15 * f15) * 0.3F + 0.5F) * f);
                        tessellator.b(-d * 1.0, -d1 * 1.0, -d2 * 1.0);
                        tessellator.a(i2 - f5 + 0.5, l2, l1 - f6 + 0.5, f11, l2 / 4.0 + f10 + f12);
                        tessellator.a(i2 + f5 + 0.5, l2, l1 + f6 + 0.5, 1.0 + f11, l2 / 4.0 + f10 + f12);
                        tessellator.a(i2 + f5 + 0.5, i3, l1 + f6 + 0.5, 1.0 + f11, i3 / 4.0 + f10 + f12);
                        tessellator.a(i2 - f5 + 0.5, i3, l1 - f6 + 0.5, f11, i3 / 4.0 + f10 + f12);
                        tessellator.b(0.0, 0.0, 0.0);
                     }
                  }
               }
            }
         }

         if (byte0 >= 0) {
            tessellator.a();
         }

         GL11.glEnable(2884);
         GL11.glDisable(3042);
         GL11.glAlphaFunc(516, 0.1F);
         this.a((double)par1);
      }
   }

   public void b() {
      agd scaledresolution = new agd(this.r.A, this.r.d, this.r.e);
      GL11.glClear(256);
      GL11.glMatrixMode(5889);
      GL11.glLoadIdentity();
      GL11.glOrtho(0.0, scaledresolution.a, scaledresolution.b, 0.0, 1000.0, 3000.0);
      GL11.glMatrixMode(5888);
      GL11.glLoadIdentity();
      GL11.glTranslatef(0.0F, 0.0F, -2000.0F);
   }

   private void g(float par1) {
      World world = this.r.f;
      EntityLiving entityliving = this.r.i;
      float f = 1.0F / (4 - this.r.A.e);
      f = 1.0F - (float)Math.pow(f, 0.25);
      bo vec3d = world.a(this.r.i, par1);
      float f1 = (float)vec3d.a;
      float f2 = (float)vec3d.b;
      float f3 = (float)vec3d.c;
      bo vec3d1 = world.g(par1);
      this.n = (float)vec3d1.a;
      this.o = (float)vec3d1.b;
      this.p = (float)vec3d1.c;
      if (this.r.A.e < 2) {
         bo vec3d2 = MathHelper.a(world.e(par1)) <= 0.0F ? bo.b(1.0, 0.0, 0.0) : bo.b(-1.0, 0.0, 0.0);
         float f5 = (float)entityliving.k(par1).b(vec3d2);
         if (f5 < 0.0F) {
            f5 = 0.0F;
         }

         if (f5 > 0.0F) {
            float[] TileEntityMobSpawnerRenderer = world.t.a(world.c(par1), par1);
            if (TileEntityMobSpawnerRenderer != null) {
               f5 *= TileEntityMobSpawnerRenderer[3];
               this.n = this.n * (1.0F - f5) + TileEntityMobSpawnerRenderer[0] * f5;
               this.o = this.o * (1.0F - f5) + TileEntityMobSpawnerRenderer[1] * f5;
               this.p = this.p * (1.0F - f5) + TileEntityMobSpawnerRenderer[2] * f5;
            }
         }
      }

      this.n = this.n + (f1 - this.n) * f;
      this.o = this.o + (f2 - this.o) * f;
      this.p = this.p + (f3 - this.p) * f;
      float f4 = world.j(par1);
      if (f4 > 0.0F) {
         float f6 = 1.0F - f4 * 0.5F;
         float f8 = 1.0F - f4 * 0.4F;
         this.n *= f6;
         this.o *= f6;
         this.p *= f8;
      }

      float f7 = world.i(par1);
      if (f7 > 0.0F) {
         float f9 = 1.0F - f7 * 0.5F;
         this.n *= f9;
         this.o *= f9;
         this.p *= f9;
      }

      int i = ActiveRenderInfo.a(this.r.f, entityliving, par1);
      if (this.U) {
         bo vec3d3 = world.f(par1);
         this.n = (float)vec3d3.a;
         this.o = (float)vec3d3.b;
         this.p = (float)vec3d3.c;
      } else if (i != 0 && Block.m[i].cd == acn.g) {
         this.n = 0.02F;
         this.o = 0.02F;
         this.p = 0.2F;
      } else if (i != 0 && Block.m[i].cd == acn.h) {
         this.n = 0.6F;
         this.o = 0.1F;
         this.p = 0.0F;
      }

      float f10 = this.ad + (this.BlockTNT - this.ad) * par1;
      this.n *= f10;
      this.o *= f10;
      this.p *= f10;
      double d = (entityliving.O + (entityliving.p - entityliving.O) * par1) * world.t.k();
      if (entityliving.a(aad.q)) {
         int j = entityliving.b(aad.q).b();
         if (j < 20) {
            d *= 1.0F - j / 20.0F;
         } else {
            d = 0.0;
         }
      }

      if (d < 1.0) {
         if (d < 0.0) {
            d = 0.0;
         }

         d *= d;
         this.n = (float)(this.n * d);
         this.o = (float)(this.o * d);
         this.p = (float)(this.p * d);
      }

      if (this.r.A.g) {
         float f11 = (this.n * 30.0F + this.o * 59.0F + this.p * 11.0F) / 100.0F;
         float f12 = (this.n * 30.0F + this.o * 70.0F) / 100.0F;
         float f13 = (this.n * 30.0F + this.p * 70.0F) / 100.0F;
         this.n = f11;
         this.o = f12;
         this.p = f13;
      }

      GL11.glClearColor(this.n, this.o, this.p, 0.0F);
   }

   private void a(int par1, float par2) {
      EntityLiving entityliving = this.r.i;
      boolean flag = false;
      if (entityliving instanceof EntityPlayer) {
         flag = ((EntityPlayer)entityliving).aT.d;
      }

      if (par1 == 999) {
         GL11.glFog(2918, this.a(0.0F, 0.0F, 0.0F, 1.0F));
         GL11.glFogi(2917, 9729);
         GL11.glFogf(2915, 0.0F);
         GL11.glFogf(2916, 8.0F);
         if (GLContext.getCapabilities().GL_NV_fog_distance) {
            GL11.glFogi(34138, 34139);
         }

         GL11.glFogf(2915, 0.0F);
      } else {
         GL11.glFog(2918, this.a(this.n, this.o, this.p, 1.0F));
         GL11.glNormal3f(0.0F, -1.0F, 0.0F);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         int i = ActiveRenderInfo.a(this.r.f, entityliving, par2);
         if (entityliving.a(aad.q)) {
            float f = 5.0F;
            int j = entityliving.b(aad.q).b();
            if (j < 20) {
               f = 5.0F + (this.s - 5.0F) * (1.0F - j / 20.0F);
            }

            GL11.glFogi(2917, 9729);
            if (par1 < 0) {
               GL11.glFogf(2915, 0.0F);
               GL11.glFogf(2916, f * 0.8F);
            } else {
               GL11.glFogf(2915, f * 0.25F);
               GL11.glFogf(2916, f);
            }

            if (GLContext.getCapabilities().GL_NV_fog_distance) {
               GL11.glFogi(34138, 34139);
            }
         } else if (this.U) {
            GL11.glFogi(2917, 2048);
            GL11.glFogf(2914, 0.1F);
            float f1 = 1.0F;
            float f5 = 1.0F;
            float f8 = 1.0F;
            if (this.r.A.g) {
               float f11 = (f1 * 30.0F + f5 * 59.0F + f8 * 11.0F) / 100.0F;
               float f15 = (f1 * 30.0F + f5 * 70.0F) / 100.0F;
               float f18 = (f1 * 30.0F + f8 * 70.0F) / 100.0F;
            }
         } else if (i > 0 && Block.m[i].cd == acn.g) {
            GL11.glFogi(2917, 2048);
            if (!entityliving.a(aad.o)) {
               GL11.glFogf(2914, 0.1F);
            } else {
               GL11.glFogf(2914, 0.05F);
            }

            float f2 = 0.4F;
            float f6 = 0.4F;
            float f9 = 0.9F;
            if (this.r.A.g) {
               float f12 = (f2 * 30.0F + f6 * 59.0F + f9 * 11.0F) / 100.0F;
               float f16 = (f2 * 30.0F + f6 * 70.0F) / 100.0F;
               float f19 = (f2 * 30.0F + f9 * 70.0F) / 100.0F;
            }
         } else if (i > 0 && Block.m[i].cd == acn.h) {
            GL11.glFogi(2917, 2048);
            GL11.glFogf(2914, 2.0F);
            float f3 = 0.4F;
            float f7 = 0.3F;
            float f10 = 0.3F;
            if (this.r.A.g) {
               float f13 = (f3 * 30.0F + f7 * 59.0F + f10 * 11.0F) / 100.0F;
               float f17 = (f3 * 30.0F + f7 * 70.0F) / 100.0F;
               float f20 = (f3 * 30.0F + f10 * 70.0F) / 100.0F;
            }
         } else {
            float f4 = this.s;
            if (this.r.f.t.j() && !flag) {
               double d = ((entityliving.b(par2) & 15728640) >> 20) / 16.0 + (entityliving.O + (entityliving.p - entityliving.O) * par2 + 4.0) / 32.0;
               if (d < 1.0) {
                  if (d < 0.0) {
                     d = 0.0;
                  }

                  d *= d;
                  float f14 = 100.0F * (float)d;
                  if (f14 < 5.0F) {
                     f14 = 5.0F;
                  }

                  if (f4 > f14) {
                     f4 = f14;
                  }
               }
            }

            GL11.glFogi(2917, 9729);
            if (par1 < 0) {
               GL11.glFogf(2915, 0.0F);
               GL11.glFogf(2916, f4 * 0.8F);
            } else {
               GL11.glFogf(2915, f4 * 0.25F);
               GL11.glFogf(2916, f4);
            }

            if (GLContext.getCapabilities().GL_NV_fog_distance) {
               GL11.glFogi(34138, 34139);
            }

            if (this.r.f.t.func_48218_b((long)entityliving.o, (long)entityliving.q)) {
               GL11.glFogf(2915, f4 * 0.05F);
               GL11.glFogf(2916, f4 * 0.5F);
            }
         }

         GL11.glEnable(2903);
         GL11.glColorMaterial(1028, 4608);
      }
   }

   private FloatBuffer a(float par1, float par2, float par3, float par4) {
      ((Buffer)this.m).clear();
      this.m.put(par1).put(par2).put(par3).put(par4);
      ((Buffer)this.m).flip();
      return this.m;
   }
}
