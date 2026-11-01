import java.nio.Buffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.ARBOcclusionQuery;
import org.lwjgl.opengl.GL11;

public class RenderGlobal implements IWorldAccess {
   public List a;
   private World i;
   private aaw j;
   private List k;
   private WorldRenderer[] l;
   private WorldRenderer[] m;
   private int n;
   private int o;
   private int p;
   private int q;
   private Minecraft r;
   private RenderBlocks s;
   private IntBuffer t;
   private boolean u;
   private int v;
   private int w;
   private int x;
   private int y;
   private long z;
   private int A;
   private long B;
   private long C;
   private int D;
   private long E;
   private int F;
   private int G;
   private int H;
   private int I;
   private int J;
   int[] b;
   IntBuffer c;
   private int K;
   private int L;
   private int M;
   private int N;
   private int O;
   private int P;
   private int Q;
   private List R;
   private RenderList[] S = new RenderList[]{new RenderList(), new RenderList(), new RenderList(), new RenderList()};
   double d;
   double e;
   double f;
   public float g;
   int h;

   public RenderGlobal (Minecraft par1Minecraft, aaw par2RenderEngine) {
      this.a = new ArrayList();
      this.k = new ArrayList();
      this.u = false;
      this.v = 0;
      this.F = -1;
      this.G = 2;
      this.b = new int[50000];
      this.c = GLAllocation.d(64);
      this.R = new ArrayList();
      this.d = -9999.0;
      this.e = -9999.0;
      this.f = -9999.0;
      this.h = 0;
      this.r = par1Minecraft;
      this.j = par2RenderEngine;
      byte byte0 = 34;
      byte byte1 = 32;
      this.q = GLAllocation.a(byte0 * byte0 * byte1 * 3);
      this.u = vm.a();
      if (this.u) {
         ((Buffer)this.c).clear();
         this.t = GLAllocation.d(byte0 * byte0 * byte1);
         ((Buffer)this.t).clear();
         ((Buffer)this.t).position(0);
         ((Buffer)this.t).limit(byte0 * byte0 * byte1);
         ARBOcclusionQuery.glGenQueriesARB(this.t);
      }

      this.w = GLAllocation.a(3);
      GL11.glPushMatrix();
      GL11.glNewList(this.w, 4864);
      this.f();
      GL11.glEndList();
      GL11.glPopMatrix();
      Tessellator tessellator = Tessellator.a;
      this.x = this.w + 1;
      GL11.glNewList(this.x, 4864);
      byte byte2 = 64;
      int i = 256 / byte2 + 2;
      float f = 16.0F;

      for (int j = -byte2 * i; j <= byte2 * i; j += byte2) {
         for (int l = -byte2 * i; l <= byte2 * i; l += byte2) {
            tessellator.b();
            tessellator.a(j + 0, f, l + 0);
            tessellator.a(j + byte2, f, l + 0);
            tessellator.a(j + byte2, f, l + byte2);
            tessellator.a(j + 0, f, l + byte2);
            tessellator.a();
         }
      }

      GL11.glEndList();
      this.y = this.w + 2;
      GL11.glNewList(this.y, 4864);
      f = -16.0F;
      tessellator.b();

      for (int k = -byte2 * i; k <= byte2 * i; k += byte2) {
         for (int i1 = -byte2 * i; i1 <= byte2 * i; i1 += byte2) {
            tessellator.a(k + byte2, f, i1 + 0);
            tessellator.a(k + 0, f, i1 + 0);
            tessellator.a(k + 0, f, i1 + byte2);
            tessellator.a(k + byte2, f, i1 + byte2);
         }
      }

      tessellator.a();
      GL11.glEndList();
   }

   private void f() {
      Random random = new Random(10842L);
      Tessellator tessellator = Tessellator.a;
      tessellator.b();

      for (int i = 0; i < 1500; i++) {
         double d = random.nextFloat() * 2.0F - 1.0F;
         double d1 = random.nextFloat() * 2.0F - 1.0F;
         double d2 = random.nextFloat() * 2.0F - 1.0F;
         double d3 = 0.25F + random.nextFloat() * 0.25F;
         double d4 = d * d + d1 * d1 + d2 * d2;
         if (!(d4 >= 1.0) && !(d4 <= 0.01)) {
            d4 = 1.0 / Math.sqrt(d4);
            d *= d4;
            d1 *= d4;
            d2 *= d4;
            double d5 = d * 100.0;
            double d6 = d1 * 100.0;
            double d7 = d2 * 100.0;
            double d8 = Math.atan2(d, d2);
            double d9 = Math.sin(d8);
            double d10 = Math.cos(d8);
            double d11 = Math.atan2(Math.sqrt(d * d + d2 * d2), d1);
            double d12 = Math.sin(d11);
            double d13 = Math.cos(d11);
            double d14 = random.nextDouble() * Math.PI * 2.0;
            double d15 = Math.sin(d14);
            double d16 = Math.cos(d14);

            for (int j = 0; j < 4; j++) {
               double d17 = 0.0;
               double d18 = ((j & 2) - 1) * d3;
               double d19 = ((j + 1 & 2) - 1) * d3;
               double d20 = d17;
               double d21 = d18 * d16 - d19 * d15;
               double d22 = d19 * d16 + d18 * d15;
               double d23 = d22;
               double d24 = d21 * d12 + d20 * d13;
               double d25 = d20 * d12 - d21 * d13;
               double d26 = d25 * d9 - d23 * d10;
               double d27 = d24;
               double d28 = d23 * d9 + d25 * d10;
               tessellator.a(d5 + d26, d6 + d27, d7 + d28);
            }
         }
      }

      tessellator.a();
   }

   public void a(World par1World) {
      if (this.i != null) {
         this.i.b(this);
      }

      this.d = -9999.0;
      this.e = -9999.0;
      this.f = -9999.0;
      RenderManager.a.a(par1World);
      this.i = par1World;
      this.s = new RenderBlocks(par1World);
      if (par1World != null) {
         par1World.a(this);
         this.a();
      }
   }

   public void a() {
      if (this.i != null) {
         Block.K.b(this.r.A.j);
         this.F = this.r.A.e;
         RenderBlocks.stripeLandsFix = this.r.A.stripeLandsFix;
         if (this.m != null) {
            for (int i = 0; i < this.m.length; i++) {
               this.m[i].c();
            }
         }

         int j = 64 << 3 - this.F;
         if (j > 480) {
            j = 480;
         }

         this.n = j / 16 + 1;
         this.o = 16;
         this.p = j / 16 + 1;
         this.m = new WorldRenderer[this.n * this.o * this.p];
         this.l = new WorldRenderer[this.n * this.o * this.p];
         int k = 0;
         int l = 0;
         this.z = 0L;
         this.A = 0;
         this.B = 0L;
         this.C = this.n;
         this.D = this.o;
         this.E = this.p;

         for (int i1 = 0; i1 < this.k.size(); i1++) {
            ((WorldRenderer)this.k.get(i1)).q = false;
         }

         this.k.clear();
         this.a.clear();

         for (int j1 = 0; j1 < this.n; j1++) {
            for (int k1 = 0; k1 < this.o; k1++) {
               for (int l1 = 0; l1 < this.p; l1++) {
                  this.m[(l1 * this.o + k1) * this.n + j1] = new WorldRenderer(this.i, this.a, j1 * 16, k1 * 16, l1 * 16, this.q + k);
                  if (this.u) {
                     this.m[(l1 * this.o + k1) * this.n + j1].v = this.t.get(l);
                  }

                  this.m[(l1 * this.o + k1) * this.n + j1].u = false;
                  this.m[(l1 * this.o + k1) * this.n + j1].t = true;
                  this.m[(l1 * this.o + k1) * this.n + j1].l = true;
                  this.m[(l1 * this.o + k1) * this.n + j1].s = l++;
                  this.m[(l1 * this.o + k1) * this.n + j1].f();
                  this.l[(l1 * this.o + k1) * this.n + j1] = this.m[(l1 * this.o + k1) * this.n + j1];
                  this.k.add(this.m[(l1 * this.o + k1) * this.n + j1]);
                  k += 3;
               }
            }
         }

         if (this.i != null) {
            EntityLiving entityliving = this.r.i;
            if (entityliving != null) {
               this.markRenderersForNewPosition(MathHelper.d(entityliving.o), MathHelper.c(entityliving.p), MathHelper.d(entityliving.q));
               Arrays.sort(this.l, new EntitySorter(entityliving));
            }
         }

         this.G = 2;
      }
   }

   public void a(bo par1Vec3D, amd par2ICamera, float par3) {
      if (this.G > 0) {
         this.G--;
      } else {
         lv.a("prepare");
         TileEntityRenderer.a.a(this.i, this.j, this.r.q, this.r.i, par3);
         RenderManager.a.a(this.i, this.j, this.r.q, this.r.i, this.r.A, par3);
         TileEntityRenderer.a.a();
         this.H = 0;
         this.I = 0;
         this.J = 0;
         EntityLiving entityliving = this.r.i;
         RenderManager.b = entityliving.N + (entityliving.o - entityliving.N) * par3;
         RenderManager.c = entityliving.O + (entityliving.p - entityliving.O) * par3;
         RenderManager.d = entityliving.P + (entityliving.q - entityliving.P) * par3;
         TileEntityRenderer.b = entityliving.N + (entityliving.o - entityliving.N) * par3;
         TileEntityRenderer.c = entityliving.O + (entityliving.p - entityliving.O) * par3;
         TileEntityRenderer.d = entityliving.P + (entityliving.q - entityliving.P) * par3;
         this.r.u.b((double)par3);
         lv.c("global");
         List list = this.i.s();
         this.H = list.size();

         for (int i = 0; i < this.i.e.size(); i++) {
            Entity entity = (Entity)this.i.e.get(i);
            this.I++;
            if (entity.a(par1Vec3D)) {
               RenderManager.a.a(entity, par3);
            }
         }

         lv.c("entities");

         for (int j = 0; j < list.size(); j++) {
            Entity entity1 = (Entity)list.get(j);
            if (entity1.a(par1Vec3D)
               && (entity1.ak || par2ICamera.a(entity1.y))
               && (entity1 != this.r.i || this.r.A.E != 0 || this.r.i.TileEntityDispenser())
               && this.i.blockExists(MathHelper.d(entity1.o), 0, MathHelper.d(entity1.q))) {
               this.I++;
               RenderManager.a.a(entity1, par3);
            }
         }

         lv.c("tileentities");
         tf.b();

         for (int k = 0; k < this.a.size(); k++) {
            TileEntityRenderer.a.a((TileEntity)this.a.get(k), par3);
         }

         this.r.u.a((double)par3);
         lv.b();
      }
   }

   public String b() {
      return "C: " + this.N + "/" + this.K + ". F: " + this.L + ", O: " + this.M + ", E: " + this.O;
   }

   public String c() {
      return "E: " + this.I + "/" + this.H + ". B: " + this.J + ", I: " + (this.H - this.J - this.I);
   }

   private void markRenderersForNewPosition(long par1, int par2, long par3) {
      par1 -= 8L;
      par2 -= 8;
      par3 -= 8L;
      this.z = Long.MIN_VALUE;
      this.A = Integer.MAX_VALUE;
      this.B = Long.MIN_VALUE;
      this.C = Long.MAX_VALUE;
      this.D = Integer.MIN_VALUE;
      this.E = Long.MAX_VALUE;
      int i = this.n * 16;
      int j = i / 2;

      for (int k = 0; k < this.n; k++) {
         long l = k * 16;
         long i1 = l + j - par1;
         if (i1 < 0L) {
            i1 -= i - 1;
         }

         i1 /= i;
         l -= i1 * i;
         if (l < this.z) {
            this.z = l;
         }

         if (l > this.C) {
            this.C = l;
         }

         for (int j1 = 0; j1 < this.p; j1++) {
            long k1 = j1 * 16;
            long l1 = k1 + j - par3;
            if (l1 < 0L) {
               l1 -= i - 1;
            }

            l1 /= i;
            k1 -= l1 * i;
            if (k1 < this.B) {
               this.B = k1;
            }

            if (k1 > this.E) {
               this.E = k1;
            }

            for (int i2 = 0; i2 < this.o; i2++) {
               int j2 = i2 * 16;
               if (j2 < this.A) {
                  this.A = j2;
               }

               if (j2 > this.D) {
                  this.D = j2;
               }

               WorldRenderer worldrenderer = this.m[(j1 * this.o + i2) * this.n + k];
               boolean flag = worldrenderer.q;
               worldrenderer.setPosition(l, j2, k1);
               if (!flag && worldrenderer.q) {
                  this.k.add(worldrenderer);
               }
            }
         }
      }
   }

   public int a(EntityLiving par1EntityLiving, int par2, double par3) {
      lv.a("sortchunks");

      for (int i = 0; i < 10; i++) {
         this.Q = (this.Q + 1) % this.m.length;
         WorldRenderer worldrenderer = this.m[this.Q];
         if (worldrenderer.q && !this.k.contains(worldrenderer)) {
            this.k.add(worldrenderer);
         }
      }

      if (this.r.A.e != this.F) {
         this.a();
      }

      if (par2 == 0) {
         this.K = 0;
         this.P = 0;
         this.L = 0;
         this.M = 0;
         this.N = 0;
         this.O = 0;
      }

      double d = par1EntityLiving.N + (par1EntityLiving.o - par1EntityLiving.N) * par3;
      double d1 = par1EntityLiving.O + (par1EntityLiving.p - par1EntityLiving.O) * par3;
      double d2 = par1EntityLiving.P + (par1EntityLiving.q - par1EntityLiving.P) * par3;
      double d3 = par1EntityLiving.o - this.d;
      double d4 = par1EntityLiving.p - this.e;
      double d5 = par1EntityLiving.q - this.f;
      if (d3 * d3 + d4 * d4 + d5 * d5 > 16.0) {
         this.d = par1EntityLiving.o;
         this.e = par1EntityLiving.p;
         this.f = par1EntityLiving.q;
         this.markRenderersForNewPosition(MathHelper.d(par1EntityLiving.o), MathHelper.c(par1EntityLiving.p), MathHelper.d(par1EntityLiving.q));
         Arrays.sort(this.l, new EntitySorter(par1EntityLiving));
      }

      tf.a();
      int j = 0;
      if (this.u && this.r.A.h && !this.r.A.g && par2 == 0) {
         int k = 0;
         int l = 16;
         this.a(k, l);

         for (int i1 = k; i1 < l; i1++) {
            this.l[i1].t = true;
         }

         lv.c("render");
         j += this.a(k, l, par2, par3);

         do {
            lv.c("occ");
            int byte0 = l;
            l *= 2;
            if (l > this.l.length) {
               l = this.l.length;
            }

            GL11.glDisable(3553);
            GL11.glDisable(2896);
            GL11.glDisable(3008);
            GL11.glDisable(2912);
            GL11.glColorMask(false, false, false, false);
            GL11.glDepthMask(false);
            lv.a("check");
            this.a(byte0, l);
            lv.b();
            GL11.glPushMatrix();
            float f = 0.0F;
            float f1 = 0.0F;
            float f2 = 0.0F;

            for (int j1 = byte0; j1 < l; j1++) {
               if (this.l[j1].e()) {
                  this.l[j1].l = false;
               } else {
                  if (!this.l[j1].l) {
                     this.l[j1].t = true;
                  }

                  if (this.l[j1].l && !this.l[j1].u) {
                     float f3 = MathHelper.a(this.l[j1].distanceToEntitySquared(par1EntityLiving));
                     int k1 = (int)(1.0F + f3 / 128.0F);
                     if (this.v % k1 == j1 % k1) {
                        WorldRenderer worldrenderer1 = this.l[j1];
                        float f4 = (float)(worldrenderer1.f - d);
                        float f5 = (float)(worldrenderer1.g - d1);
                        float f6 = (float)(worldrenderer1.h - d2);
                        float f7 = f4 - f;
                        float f8 = f5 - f1;
                        float f9 = f6 - f2;
                        if (f7 != 0.0F || f8 != 0.0F || f9 != 0.0F) {
                           GL11.glTranslatef(f7, f8, f9);
                           f += f7;
                           f1 += f8;
                           f2 += f9;
                        }

                        lv.a("ItemBucket");
                        ARBOcclusionQuery.glBeginQueryARB(35092, this.l[j1].v);
                        this.l[j1].d();
                        ARBOcclusionQuery.glEndQueryARB(35092);
                        lv.b();
                        this.l[j1].u = true;
                     }
                  }
               }
            }

            GL11.glPopMatrix();
            if (this.r.A.g) {
               if (EntityRenderer.b == 0) {
                  GL11.glColorMask(false, true, true, true);
               } else {
                  GL11.glColorMask(true, false, false, true);
               }
            } else {
               GL11.glColorMask(true, true, true, true);
            }

            GL11.glDepthMask(true);
            GL11.glEnable(3553);
            GL11.glEnable(3008);
            GL11.glEnable(2912);
            lv.c("render");
            j += this.a(byte0, l, par2, par3);
         } while (l < this.l.length);
      } else {
         lv.c("render");
         j += this.a(0, this.l.length, par2, par3);
      }

      lv.b();
      return j;
   }

   private void a(int par1, int par2) {
      for (int i = par1; i < par2; i++) {
         if (this.l[i].u) {
            ((Buffer)this.c).clear();
            ARBOcclusionQuery.glGetQueryObjectuARB(this.l[i].v, 34919, this.c);
            if (this.c.get(0) != 0) {
               this.l[i].u = false;
               ((Buffer)this.c).clear();
               ARBOcclusionQuery.glGetQueryObjectuARB(this.l[i].v, 34918, this.c);
               this.l[i].t = this.c.get(0) != 0;
            }
         }
      }
   }

   private int a(int par1, int par2, int par3, double par4) {
      this.R.clear();
      int i = 0;

      for (int j = par1; j < par2; j++) {
         if (par3 == 0) {
            this.K++;
            if (this.l[j].m[par3]) {
               this.O++;
            } else if (!this.l[j].l) {
               this.L++;
            } else if (this.u && !this.l[j].t) {
               this.M++;
            } else {
               this.N++;
            }
         }

         if (!this.l[j].m[par3] && this.l[j].l && (!this.u || this.l[j].t)) {
            int k = this.l[j].a(par3);
            if (k >= 0) {
               this.R.add(this.l[j]);
               i++;
            }
         }
      }

      EntityLiving entityliving = this.r.i;
      double d = entityliving.N + (entityliving.o - entityliving.N) * par4;
      double d1 = entityliving.O + (entityliving.p - entityliving.O) * par4;
      double d2 = entityliving.P + (entityliving.q - entityliving.P) * par4;
      int l = 0;

      for (int i1 = 0; i1 < this.S.length; i1++) {
         this.S[i1].b();
      }

      for (int j1 = 0; j1 < this.R.size(); j1++) {
         WorldRenderer worldrenderer = (WorldRenderer)this.R.get(j1);
         int k1 = -1;

         for (int l1 = 0; l1 < l; l1++) {
            if (this.S[l1].func_862_a(worldrenderer.f, worldrenderer.g, worldrenderer.h)) {
               k1 = l1;
            }
         }

         if (k1 < 0) {
            k1 = l++;
            this.S[k1].func_861_a(worldrenderer.f, worldrenderer.g, worldrenderer.h, d, d1, d2);
         }

         this.S[k1].a(worldrenderer.a(par3));
      }

      this.a(par3, par4);
      return i;
   }

   public void a(int par1, double par2) {
      this.r.u.b(par2);

      for (int i = 0; i < this.S.length; i++) {
         this.S[i].a();
      }

      this.r.u.a(par2);
   }

   public void d() {
      this.v++;
   }

   public void a(float par1) {
      if (this.r.f.t.g == 1) {
         GL11.glDisable(2912);
         GL11.glDisable(3008);
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 771);
         tf.a();
         GL11.glDepthMask(false);
         this.j.b(this.j.b("/misc/tunnel.png"));
         Tessellator tessellator = Tessellator.a;

         for (int i = 0; i < 6; i++) {
            GL11.glPushMatrix();
            if (i == 1) {
               GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
            }

            if (i == 2) {
               GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
            }

            if (i == 3) {
               GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
            }

            if (i == 4) {
               GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
            }

            if (i == 5) {
               GL11.glRotatef(-90.0F, 0.0F, 0.0F, 1.0F);
            }

            tessellator.b();
            tessellator.c(1579032);
            tessellator.a(-100.0, -100.0, -100.0, 0.0, 0.0);
            tessellator.a(-100.0, -100.0, 100.0, 0.0, 16.0);
            tessellator.a(100.0, -100.0, 100.0, 16.0, 16.0);
            tessellator.a(100.0, -100.0, -100.0, 16.0, 0.0);
            tessellator.a();
            GL11.glPopMatrix();
         }

         GL11.glDepthMask(true);
         GL11.glEnable(3553);
         GL11.glEnable(3008);
      } else if (this.r.f.t.e()) {
         GL11.glDisable(3553);
         bo vec3d = this.i.a(this.r.i, par1);
         float f = (float)vec3d.a;
         float f1 = (float)vec3d.b;
         float f2 = (float)vec3d.c;
         if (this.r.A.g) {
            float f3 = (f * 30.0F + f1 * 59.0F + f2 * 11.0F) / 100.0F;
            float f4 = (f * 30.0F + f1 * 70.0F) / 100.0F;
            float f5 = (f * 30.0F + f2 * 70.0F) / 100.0F;
            f = f3;
            f1 = f4;
            f2 = f5;
         }

         GL11.glColor3f(f, f1, f2);
         Tessellator tessellator1 = Tessellator.a;
         GL11.glDepthMask(false);
         GL11.glEnable(2912);
         GL11.glColor3f(f, f1, f2);
         GL11.glCallList(this.x);
         GL11.glDisable(2912);
         GL11.glDisable(3008);
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 771);
         tf.a();
         float[] TileEntityMobSpawnerRenderer = this.i.t.a(this.i.c(par1), par1);
         if (TileEntityMobSpawnerRenderer != null) {
            GL11.glDisable(3553);
            GL11.glShadeModel(7425);
            GL11.glPushMatrix();
            GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
            GL11.glRotatef(MathHelper.a(this.i.e(par1)) >= 0.0F ? 0.0F : 180.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
            float f6 = TileEntityMobSpawnerRenderer[0];
            float f8 = TileEntityMobSpawnerRenderer[1];
            float f11 = TileEntityMobSpawnerRenderer[2];
            if (this.r.A.g) {
               float f14 = (f6 * 30.0F + f8 * 59.0F + f11 * 11.0F) / 100.0F;
               float f17 = (f6 * 30.0F + f8 * 70.0F) / 100.0F;
               float f20 = (f6 * 30.0F + f11 * 70.0F) / 100.0F;
               f6 = f14;
               f8 = f17;
               f11 = f20;
            }

            tessellator1.a(6);
            tessellator1.a(f6, f8, f11, TileEntityMobSpawnerRenderer[3]);
            tessellator1.a(0.0, 100.0, 0.0);
            int j = 16;
            tessellator1.a(TileEntityMobSpawnerRenderer[0], TileEntityMobSpawnerRenderer[1], TileEntityMobSpawnerRenderer[2], 0.0F);

            for (int k = 0; k <= j; k++) {
               float f21 = k * (float) Math.PI * 2.0F / j;
               float f22 = MathHelper.a(f21);
               float f23 = MathHelper.b(f21);
               tessellator1.a((double)(f22 * 120.0F), (double)(f23 * 120.0F), (double)(-f23 * 40.0F * TileEntityMobSpawnerRenderer[3]));
            }

            tessellator1.a();
            GL11.glPopMatrix();
            GL11.glShadeModel(7424);
         }

         GL11.glEnable(3553);
         GL11.glBlendFunc(770, 1);
         GL11.glPushMatrix();
         double d = 1.0F - this.i.j(par1);
         float f7 = 0.0F;
         float f9 = 0.0F;
         float f12 = 0.0F;
         GL11.glColor4f(1.0F, 1.0F, 1.0F, (float)d);
         GL11.glTranslatef(f7, f9, f12);
         GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(this.i.c(par1) * 360.0F, 1.0F, 0.0F, 0.0F);
         float f15 = 30.0F;
         GL11.glBindTexture(3553, this.j.b("/terrain/sun.png"));
         tessellator1.b();
         tessellator1.a(-f15, 100.0, -f15, 0.0, 0.0);
         tessellator1.a(f15, 100.0, -f15, 1.0, 0.0);
         tessellator1.a(f15, 100.0, f15, 1.0, 1.0);
         tessellator1.a(-f15, 100.0, f15, 0.0, 1.0);
         tessellator1.a();
         f15 = 20.0F;
         GL11.glBindTexture(3553, this.j.b("/terrain/moon_phases.png"));
         int i18 = this.i.d(par1);
         int l = i18 % 4;
         int i1 = i18 / 4 % 2;
         float f24 = (l + 0) / 4.0F;
         float f25 = (i1 + 0) / 2.0F;
         float f26 = (l + 1) / 4.0F;
         float f27 = (i1 + 1) / 2.0F;
         tessellator1.b();
         tessellator1.a(-f15, -100.0, f15, f26, f27);
         tessellator1.a(f15, -100.0, f15, f24, f27);
         tessellator1.a(f15, -100.0, -f15, f24, f25);
         tessellator1.a(-f15, -100.0, -f15, f26, f25);
         tessellator1.a();
         GL11.glDisable(3553);
         float f18 = (float)(this.i.h(par1) * d);
         if (f18 > 0.0F) {
            GL11.glColor4f(f18, f18, f18, f18);
            GL11.glCallList(this.w);
         }

         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         GL11.glDisable(3042);
         GL11.glEnable(3008);
         GL11.glEnable(2912);
         GL11.glPopMatrix();
         GL11.glDisable(3553);
         GL11.glColor3f(0.0F, 0.0F, 0.0F);
         d = this.r.h.j(par1).b - this.i.I();
         if (d < 0.0) {
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, 12.0F, 0.0F);
            GL11.glCallList(this.y);
            GL11.glPopMatrix();
            float f10 = 1.0F;
            float f13 = -((float)(d + 65.0));
            float f16 = -f10;
            float f19 = f13;
            tessellator1.b();
            tessellator1.a(0, 255);
            tessellator1.a((double)(-f10), (double)f19, (double)f10);
            tessellator1.a((double)f10, (double)f19, (double)f10);
            tessellator1.a((double)f10, (double)f16, (double)f10);
            tessellator1.a((double)(-f10), (double)f16, (double)f10);
            tessellator1.a((double)(-f10), (double)f16, (double)(-f10));
            tessellator1.a((double)f10, (double)f16, (double)(-f10));
            tessellator1.a((double)f10, (double)f19, (double)(-f10));
            tessellator1.a((double)(-f10), (double)f19, (double)(-f10));
            tessellator1.a((double)f10, (double)f16, (double)(-f10));
            tessellator1.a((double)f10, (double)f16, (double)f10);
            tessellator1.a((double)f10, (double)f19, (double)f10);
            tessellator1.a((double)f10, (double)f19, (double)(-f10));
            tessellator1.a((double)(-f10), (double)f19, (double)(-f10));
            tessellator1.a((double)(-f10), (double)f19, (double)f10);
            tessellator1.a((double)(-f10), (double)f16, (double)f10);
            tessellator1.a((double)(-f10), (double)f16, (double)(-f10));
            tessellator1.a((double)(-f10), (double)f16, (double)(-f10));
            tessellator1.a((double)(-f10), (double)f16, (double)f10);
            tessellator1.a((double)f10, (double)f16, (double)f10);
            tessellator1.a((double)f10, (double)f16, (double)(-f10));
            tessellator1.a();
         }

         if (this.i.t.c()) {
            GL11.glColor3f(f * 0.2F + 0.04F, f1 * 0.2F + 0.04F, f2 * 0.6F + 0.1F);
         } else {
            GL11.glColor3f(f, f1, f2);
         }

         GL11.glPushMatrix();
         GL11.glTranslatef(0.0F, -((float)(d - 16.0)), 0.0F);
         GL11.glCallList(this.y);
         GL11.glPopMatrix();
         GL11.glEnable(3553);
         GL11.glDepthMask(true);
      }
   }

   public void b(float par1) {
      if (this.r.f.t.e()) {
         if (this.r.A.j) {
            this.c(par1);
         } else {
            GL11.glDisable(2884);
            float f = (float)(this.r.i.O + (this.r.i.p - this.r.i.O) * par1);
            byte byte0 = 32;
            int i = 256 / byte0;
            Tessellator tessellator = Tessellator.a;
            GL11.glBindTexture(3553, this.j.b("/environment/clouds.png"));
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            bo vec3d = this.i.f(par1);
            float f1 = (float)vec3d.a;
            float f2 = (float)vec3d.b;
            float f3 = (float)vec3d.c;
            if (this.r.A.g) {
               float f4 = (f1 * 30.0F + f2 * 59.0F + f3 * 11.0F) / 100.0F;
               float f6 = (f1 * 30.0F + f2 * 70.0F) / 100.0F;
               float f7 = (f1 * 30.0F + f3 * 70.0F) / 100.0F;
               f1 = f4;
               f2 = f6;
               f3 = f7;
            }

            double f5 = 4.882813E-4;
            double d = (double)this.v + par1;
            double d1 = this.r.i.l + (this.r.i.o - this.r.i.l) * par1 + d * 0.03F;
            double d2 = this.r.i.n + (this.r.i.q - this.r.i.n) * par1;
            long j = MathHelper.d(d1 / 2048.0);
            long k = MathHelper.d(d2 / 2048.0);
            d1 -= j * 2048L;
            d2 -= k * 2048L;
            float f8 = this.i.t.f() - f + 0.33F;
            double f9 = d1 * f5;
            double f10 = d2 * f5;
            tessellator.b();
            tessellator.a(f1, f2, f3, 0.8F);

            for (int l = -byte0 * i; l < byte0 * i; l += byte0) {
               for (int i1 = -byte0 * i; i1 < byte0 * i; i1 += byte0) {
                  tessellator.a(l + 0, f8, i1 + byte0, (l + 0) * f5 + f9, (i1 + byte0) * f5 + f10);
                  tessellator.a(l + byte0, f8, i1 + byte0, (l + byte0) * f5 + f9, (i1 + byte0) * f5 + f10);
                  tessellator.a(l + byte0, f8, i1 + 0, (l + byte0) * f5 + f9, (i1 + 0) * f5 + f10);
                  tessellator.a(l + 0, f8, i1 + 0, (l + 0) * f5 + f9, (i1 + 0) * f5 + f10);
               }
            }

            tessellator.a();
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glDisable(3042);
            GL11.glEnable(2884);
         }
      }
   }

   public boolean a(double par1, double par3, double d, float f) {
      return false;
   }

   public void c(float par1) {
      GL11.glDisable(2884);
      float f = (float)(this.r.i.O + (this.r.i.p - this.r.i.O) * par1);
      Tessellator tessellator = Tessellator.a;
      float f1 = 12.0F;
      float f2 = 4.0F;
      double d = (double)this.v + par1;
      double d1 = (this.r.i.l + (this.r.i.o - this.r.i.l) * par1 + d * 0.03F) / f1;
      double d2 = (this.r.i.n + (this.r.i.q - this.r.i.n) * par1) / f1 + 0.33F;
      float f3 = this.i.t.f() - f + 0.33F;
      long i = MathHelper.d(d1 / 2048.0);
      long j = MathHelper.d(d2 / 2048.0);
      d1 -= i * 2048L;
      d2 -= j * 2048L;
      GL11.glBindTexture(3553, this.j.b("/environment/clouds.png"));
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      bo vec3d = this.i.f(par1);
      float f4 = (float)vec3d.a;
      float f5 = (float)vec3d.b;
      float f6 = (float)vec3d.c;
      if (this.r.A.g) {
         float f7 = (f4 * 30.0F + f5 * 59.0F + f6 * 11.0F) / 100.0F;
         float f9 = (f4 * 30.0F + f5 * 70.0F) / 100.0F;
         float f11 = (f4 * 30.0F + f6 * 70.0F) / 100.0F;
         f4 = f7;
         f5 = f9;
         f6 = f11;
      }

      double f8 = d1 * 0.0;
      double f10 = d2 * 0.0;
      double f12 = 0.00390625;
      f8 = MathHelper.d(d1) * f12;
      f10 = MathHelper.d(d2) * f12;
      double f13 = d1 - MathHelper.d(d1);
      double f14 = d2 - MathHelper.d(d2);
      int k = 8;
      byte byte0 = 4;
      double f15 = 9.765625E-4;
      GL11.glScalef(f1, 1.0F, f1);

      for (int l = 0; l < 2; l++) {
         if (l == 0) {
            GL11.glColorMask(false, false, false, false);
         } else if (this.r.A.g) {
            if (EntityRenderer.b == 0) {
               GL11.glColorMask(false, true, true, true);
            } else {
               GL11.glColorMask(true, false, false, true);
            }
         } else {
            GL11.glColorMask(true, true, true, true);
         }

         for (int i1 = -byte0 + 1; i1 <= byte0; i1++) {
            for (int j1 = -byte0 + 1; j1 <= byte0; j1++) {
               tessellator.b();
               double f16 = i1 * k;
               double f17 = j1 * k;
               double f18 = f16 - f13;
               double f19 = f17 - f14;
               if (f3 > -f2 - 1.0F) {
                  tessellator.a(f4 * 0.7F, f5 * 0.7F, f6 * 0.7F, 0.8F);
                  tessellator.b(0.0F, -1.0F, 0.0F);
                  tessellator.a(f18 + 0.0, f3 + 0.0F, f19 + k, (f16 + 0.0) * f12 + f8, (f17 + k) * f12 + f10);
                  tessellator.a(f18 + k, f3 + 0.0F, f19 + k, (f16 + k) * f12 + f8, (f17 + k) * f12 + f10);
                  tessellator.a(f18 + k, f3 + 0.0F, f19 + 0.0, (f16 + k) * f12 + f8, (f17 + 0.0) * f12 + f10);
                  tessellator.a(f18 + 0.0, f3 + 0.0F, f19 + 0.0, (f16 + 0.0) * f12 + f8, (f17 + 0.0) * f12 + f10);
               }

               if (f3 <= f2 + 1.0F) {
                  tessellator.a(f4, f5, f6, 0.8F);
                  tessellator.b(0.0F, 1.0F, 0.0F);
                  tessellator.a(f18 + 0.0, f3 + f2 - f15, f19 + k, (f16 + 0.0) * f12 + f8, (f17 + k) * f12 + f10);
                  tessellator.a(f18 + k, f3 + f2 - f15, f19 + k, (f16 + k) * f12 + f8, (f17 + k) * f12 + f10);
                  tessellator.a(f18 + k, f3 + f2 - f15, f19 + 0.0, (f16 + k) * f12 + f8, (f17 + 0.0) * f12 + f10);
                  tessellator.a(f18 + 0.0, f3 + f2 - f15, f19 + 0.0, (f16 + 0.0) * f12 + f8, (f17 + 0.0) * f12 + f10);
               }

               tessellator.a(f4 * 0.9F, f5 * 0.9F, f6 * 0.9F, 0.8F);
               if (i1 > -1) {
                  tessellator.b(-1.0F, 0.0F, 0.0F);

                  for (int k1 = 0; k1 < k; k1++) {
                     tessellator.a(f18 + k1, f3 + 0.0F, f19 + k, (f16 + k1 + 0.5) * f12 + f8, (f17 + k) * f12 + f10);
                     tessellator.a(f18 + k1, f3 + f2, f19 + k, (f16 + k1 + 0.5) * f12 + f8, (f17 + k) * f12 + f10);
                     tessellator.a(f18 + k1, f3 + f2, f19 + 0.0, (f16 + k1 + 0.5) * f12 + f8, (f17 + 0.0) * f12 + f10);
                     tessellator.a(f18 + k1, f3 + 0.0F, f19 + 0.0, (f16 + k1 + 0.5) * f12 + f8, (f17 + 0.0) * f12 + f10);
                  }
               }

               if (i1 <= 1) {
                  tessellator.b(1.0F, 0.0F, 0.0F);

                  for (int l1 = 0; l1 < k; l1++) {
                     tessellator.a(f18 + l1 + 1.0 - f15, f3 + 0.0F, f19 + k, (f16 + l1 + 0.5) * f12 + f8, (f17 + k) * f12 + f10);
                     tessellator.a(f18 + l1 + 1.0 - f15, f3 + f2, f19 + k, (f16 + l1 + 0.5) * f12 + f8, (f17 + k) * f12 + f10);
                     tessellator.a(f18 + l1 + 1.0 - f15, f3 + f2, f19 + 0.0, (f16 + l1 + 0.5) * f12 + f8, (f17 + 0.0) * f12 + f10);
                     tessellator.a(f18 + l1 + 1.0 - f15, f3 + 0.0F, f19 + 0.0, (f16 + l1 + 0.5) * f12 + f8, (f17 + 0.0) * f12 + f10);
                  }
               }

               tessellator.a(f4 * 0.8F, f5 * 0.8F, f6 * 0.8F, 0.8F);
               if (j1 > -1) {
                  tessellator.b(0.0F, 0.0F, -1.0F);

                  for (int i2 = 0; i2 < k; i2++) {
                     tessellator.a(f18 + 0.0, f3 + f2, f19 + i2 + 0.0, (f16 + 0.0) * f12 + f8, (f17 + i2 + 0.5) * f12 + f10);
                     tessellator.a(f18 + k, f3 + f2, f19 + i2 + 0.0, (f16 + k) * f12 + f8, (f17 + i2 + 0.5) * f12 + f10);
                     tessellator.a(f18 + k, f3 + 0.0F, f19 + i2 + 0.0, (f16 + k) * f12 + f8, (f17 + i2 + 0.5) * f12 + f10);
                     tessellator.a(f18 + 0.0, f3 + 0.0F, f19 + i2 + 0.0, (f16 + 0.0) * f12 + f8, (f17 + i2 + 0.5) * f12 + f10);
                  }
               }

               if (j1 <= 1) {
                  tessellator.b(0.0F, 0.0F, 1.0F);

                  for (int j2 = 0; j2 < k; j2++) {
                     tessellator.a(f18 + 0.0, f3 + f2, f19 + j2 + 1.0 - f15, (f16 + 0.0) * f12 + f8, (f17 + j2 + 0.5) * f12 + f10);
                     tessellator.a(f18 + k, f3 + f2, f19 + j2 + 1.0 - f15, (f16 + k) * f12 + f8, (f17 + j2 + 0.5) * f12 + f10);
                     tessellator.a(f18 + k, f3 + 0.0F, f19 + j2 + 1.0 - f15, (f16 + k) * f12 + f8, (f17 + j2 + 0.5) * f12 + f10);
                     tessellator.a(f18 + 0.0, f3 + 0.0F, f19 + j2 + 1.0 - f15, (f16 + 0.0) * f12 + f8, (f17 + j2 + 0.5) * f12 + f10);
                  }
               }

               tessellator.a();
            }
         }
      }

      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GL11.glDisable(3042);
      GL11.glEnable(2884);
   }

   public boolean a(EntityLiving par1EntityLiving, boolean par2) {
      boolean flag = false;
      if (flag) {
         Collections.sort(this.k, new RenderSorter(par1EntityLiving));
         int i = this.k.size() - 1;
         int j = this.k.size();

         for (int k = 0; k < j; k++) {
            WorldRenderer worldrenderer = (WorldRenderer)this.k.get(i - k);
            if (!par2) {
               if (worldrenderer.distanceToEntitySquared(par1EntityLiving) > 256.0) {
                  if (worldrenderer.l) {
                     if (k >= 30) {
                        return false;
                     }
                  } else if (k >= 1) {
                     return false;
                  }
               }
            } else if (!worldrenderer.l) {
               continue;
            }

            worldrenderer.a();
            this.k.remove(worldrenderer);
            worldrenderer.q = false;
         }

         return this.k.size() == 0;
      } else {
         byte byte0 = 2;
         RenderSorter rendersorter = new RenderSorter(par1EntityLiving);
         WorldRenderer[] aworldrenderer = new WorldRenderer[byte0];
         ArrayList arraylist = null;
         int l = this.k.size();
         int i1 = 0;

         for (int j1 = 0; j1 < l; j1++) {
            WorldRenderer worldrenderer1 = (WorldRenderer)this.k.get(j1);
            if (!par2) {
               if (worldrenderer1.distanceToEntitySquared(par1EntityLiving) > 256.0) {
                  int k2 = 0;

                  while (k2 < byte0 && (aworldrenderer[k2] == null || rendersorter.a(aworldrenderer[k2], worldrenderer1) <= 0)) {
                     k2++;
                  }

                  if (--k2 <= 0) {
                     continue;
                  }

                  int i3 = k2;

                  while (--i3 != 0) {
                     aworldrenderer[i3 - 1] = aworldrenderer[i3];
                  }

                  aworldrenderer[k2] = worldrenderer1;
                  continue;
               }
            } else if (!worldrenderer1.l) {
               continue;
            }

            if (arraylist == null) {
               arraylist = new ArrayList();
            }

            i1++;
            arraylist.add(worldrenderer1);
            this.k.set(j1, null);
         }

         if (arraylist != null) {
            if (arraylist.size() > 1) {
               Collections.sort(arraylist, rendersorter);
            }

            for (int k1 = arraylist.size() - 1; k1 >= 0; k1--) {
               WorldRenderer worldrenderer2 = (WorldRenderer)arraylist.get(k1);
               worldrenderer2.a();
               worldrenderer2.q = false;
            }
         }

         int l1 = 0;

         for (int i2 = byte0 - 1; i2 >= 0; i2--) {
            WorldRenderer worldrenderer3 = aworldrenderer[i2];
            if (worldrenderer3 != null) {
               if (!worldrenderer3.l && i2 != byte0 - 1) {
                  aworldrenderer[i2] = null;
                  aworldrenderer[0] = null;
                  break;
               }

               aworldrenderer[i2].a();
               aworldrenderer[i2].q = false;
               l1++;
            }
         }

         int j2 = 0;
         int l2 = 0;

         for (int j3 = this.k.size(); j2 != j3; j2++) {
            WorldRenderer worldrenderer4 = (WorldRenderer)this.k.get(j2);
            if (worldrenderer4 != null) {
               boolean flag1 = false;

               for (int k3 = 0; k3 < byte0 && !flag1; k3++) {
                  if (worldrenderer4 == aworldrenderer[k3]) {
                     flag1 = true;
                  }
               }

               if (!flag1) {
                  if (l2 != j2) {
                     this.k.set(l2, worldrenderer4);
                  }

                  l2++;
               }
            }
         }

         while (--j2 >= l2) {
            this.k.remove(j2);
         }

         return l == i1 + l1;
      }
   }

   public void a(EntityPlayer par1EntityPlayer, MovingObjectPosition par2MovingObjectPosition, int par3, ItemStack par4ItemStack, float par5) {
      Tessellator tessellator = Tessellator.a;
      GL11.glEnable(3042);
      GL11.glEnable(3008);
      GL11.glBlendFunc(770, 1);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, (MathHelper.a((float)System.currentTimeMillis() / 100.0F) * 0.2F + 0.4F) * 0.5F);
      if (par3 == 0) {
         if (this.g > 0.0F) {
            GL11.glBlendFunc(774, 768);
            int i = this.j.b("/terrain.png");
            GL11.glBindTexture(3553, i);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.5F);
            GL11.glPushMatrix();
            int j = this.i.getBlockId(par2MovingObjectPosition.b, par2MovingObjectPosition.c, par2MovingObjectPosition.d);
            Block block = j <= 0 ? null : Block.m[j];
            GL11.glDisable(3008);
            GL11.glPolygonOffset(-3.0F, -3.0F);
            GL11.glEnable(32823);
            double d = par1EntityPlayer.N + (par1EntityPlayer.o - par1EntityPlayer.N) * par5;
            double d1 = par1EntityPlayer.O + (par1EntityPlayer.p - par1EntityPlayer.O) * par5;
            double d2 = par1EntityPlayer.P + (par1EntityPlayer.q - par1EntityPlayer.P) * par5;
            if (block == null) {
               block = Block.t;
            }

            GL11.glEnable(3008);
            tessellator.b();
            tessellator.b(-d, -d1, -d2);
            tessellator.c();
            this.s.isHitbox = true;
            this.s
               .renderBlockUsingTexture(block, par2MovingObjectPosition.b, par2MovingObjectPosition.c, par2MovingObjectPosition.d, 240 + (int)(this.g * 10.0F));
            this.s.isHitbox = false;
            tessellator.a();
            tessellator.b(0.0, 0.0, 0.0);
            GL11.glDisable(3008);
            GL11.glPolygonOffset(0.0F, 0.0F);
            GL11.glDisable(32823);
            GL11.glEnable(3008);
            GL11.glDepthMask(true);
            GL11.glPopMatrix();
         }
      } else if (par4ItemStack != null) {
         GL11.glBlendFunc(770, 771);
         float f = MathHelper.a((float)System.currentTimeMillis() / 100.0F) * 0.2F + 0.8F;
         GL11.glColor4f(f, f, f, MathHelper.a((float)System.currentTimeMillis() / 200.0F) * 0.2F + 0.5F);
         int k = this.j.b("/terrain.png");
         GL11.glBindTexture(3553, k);
         long l = par2MovingObjectPosition.b;
         int i1 = par2MovingObjectPosition.c;
         long j1 = par2MovingObjectPosition.d;
         if (par2MovingObjectPosition.e == 0) {
            i1--;
         }

         if (par2MovingObjectPosition.e == 1) {
            i1++;
         }

         if (par2MovingObjectPosition.e == 2) {
            j1--;
         }

         if (par2MovingObjectPosition.e == 3) {
            j1++;
         }

         if (par2MovingObjectPosition.e == 4) {
            l--;
         }

         if (par2MovingObjectPosition.e == 5) {
            l++;
         }
      }

      GL11.glDisable(3042);
      GL11.glDisable(3008);
   }

   public void b(EntityPlayer par1EntityPlayer, MovingObjectPosition par2MovingObjectPosition, int par3, ItemStack par4ItemStack, float par5) {
      if (par3 == 0 && par2MovingObjectPosition.a == aat.a) {
         GL11.glEnable(3042);
         GL11.glBlendFunc(770, 771);
         GL11.glColor4f(0.0F, 0.0F, 0.0F, 0.4F);
         GL11.glLineWidth(2.0F);
         GL11.glDisable(3553);
         GL11.glDepthMask(false);
         float f = 0.002F;
         int i = this.i.getBlockId(par2MovingObjectPosition.b, par2MovingObjectPosition.c, par2MovingObjectPosition.d);
         if (i > 0) {
            Block.m[i].setBlockBoundsBasedOnState(this.i, par2MovingObjectPosition.b, par2MovingObjectPosition.c, par2MovingObjectPosition.d);
            double d = par1EntityPlayer.N + (par1EntityPlayer.o - par1EntityPlayer.N) * par5;
            double d1 = par1EntityPlayer.O + (par1EntityPlayer.p - par1EntityPlayer.O) * par5;
            double d2 = par1EntityPlayer.P + (par1EntityPlayer.q - par1EntityPlayer.P) * par5;
            this.a(
               Block.m[i]
                  .getSelectedBoundingBoxFromPool(this.i, par2MovingObjectPosition.b, par2MovingObjectPosition.c, par2MovingObjectPosition.d)
                  .b(f, f, f)
                  .c(-d, -d1, -d2)
            );
         }

         GL11.glDepthMask(true);
         GL11.glEnable(3553);
         GL11.glDisable(3042);
      }
   }

   private void a(AxisAlignedBB par1AxisAlignedBB) {
      Tessellator tessellator = Tessellator.a;
      tessellator.a(3);
      tessellator.a(par1AxisAlignedBB.a, par1AxisAlignedBB.b, par1AxisAlignedBB.c);
      tessellator.a(par1AxisAlignedBB.d, par1AxisAlignedBB.b, par1AxisAlignedBB.c);
      tessellator.a(par1AxisAlignedBB.d, par1AxisAlignedBB.b, par1AxisAlignedBB.f);
      tessellator.a(par1AxisAlignedBB.a, par1AxisAlignedBB.b, par1AxisAlignedBB.f);
      tessellator.a(par1AxisAlignedBB.a, par1AxisAlignedBB.b, par1AxisAlignedBB.c);
      tessellator.a();
      tessellator.a(3);
      tessellator.a(par1AxisAlignedBB.a, par1AxisAlignedBB.e, par1AxisAlignedBB.c);
      tessellator.a(par1AxisAlignedBB.d, par1AxisAlignedBB.e, par1AxisAlignedBB.c);
      tessellator.a(par1AxisAlignedBB.d, par1AxisAlignedBB.e, par1AxisAlignedBB.f);
      tessellator.a(par1AxisAlignedBB.a, par1AxisAlignedBB.e, par1AxisAlignedBB.f);
      tessellator.a(par1AxisAlignedBB.a, par1AxisAlignedBB.e, par1AxisAlignedBB.c);
      tessellator.a();
      tessellator.a(1);
      tessellator.a(par1AxisAlignedBB.a, par1AxisAlignedBB.b, par1AxisAlignedBB.c);
      tessellator.a(par1AxisAlignedBB.a, par1AxisAlignedBB.e, par1AxisAlignedBB.c);
      tessellator.a(par1AxisAlignedBB.d, par1AxisAlignedBB.b, par1AxisAlignedBB.c);
      tessellator.a(par1AxisAlignedBB.d, par1AxisAlignedBB.e, par1AxisAlignedBB.c);
      tessellator.a(par1AxisAlignedBB.d, par1AxisAlignedBB.b, par1AxisAlignedBB.f);
      tessellator.a(par1AxisAlignedBB.d, par1AxisAlignedBB.e, par1AxisAlignedBB.f);
      tessellator.a(par1AxisAlignedBB.a, par1AxisAlignedBB.b, par1AxisAlignedBB.f);
      tessellator.a(par1AxisAlignedBB.a, par1AxisAlignedBB.e, par1AxisAlignedBB.f);
      tessellator.a();
   }

   public void markBlocksForUpdate(long par1, int par2, long par3, long par4, int par5, long par6) {
      long i = MathHelper.bucketLong(par1, 16L);
      int j = MathHelper.a(par2, 16);
      long k = MathHelper.bucketLong(par3, 16L);
      long l = MathHelper.bucketLong(par4, 16L);
      int i1 = MathHelper.a(par5, 16);
      long j1 = MathHelper.bucketLong(par6, 16L);

      for (long k1 = i; k1 <= l; k1++) {
         long l1 = k1 % this.n;
         if (l1 < 0L) {
            l1 += this.n;
         }

         for (int i2 = j; i2 <= i1; i2++) {
            int j2 = i2 % this.o;
            if (j2 < 0) {
               j2 += this.o;
            }

            for (long k2 = k; k2 <= j1; k2++) {
               long l2 = k2 % this.p;
               if (l2 < 0L) {
                  l2 += this.p;
               }

               int i3 = (int)((l2 * this.o + j2) * this.n + l1);
               WorldRenderer worldrenderer = this.m[i3];
               if (!worldrenderer.q) {
                  this.k.add(worldrenderer);
                  worldrenderer.f();
               }
            }
         }
      }
   }

   @Override
   public void markBlockNeedsUpdate(long par1, int par2, long par3) {
      this.markBlocksForUpdate(par1 - 1L, par2 - 1, par3 - 1L, par1 + 1L, par2 + 1, par3 + 1L);
   }

   @Override
   public void markBlockNeedsUpdate2(long par1, int par2, long par3) {
      this.markBlocksForUpdate(par1 - 1L, par2 - 1, par3 - 1L, par1 + 1L, par2 + 1, par3 + 1L);
   }

   @Override
   public void markBlockRangeNeedsUpdate(long par1, int par2, long par3, long par4, int par5, long par6) {
      this.markBlocksForUpdate(par1 - 1L, par2 - 1, par3 - 1L, par4 + 1L, par5 + 1, par6 + 1L);
   }

   public void a(amd par1ICamera, float par2) {
      for (int i = 0; i < this.m.length; i++) {
         if (!this.m[i].e() && (!this.m[i].l || (i + this.h & 15) == 0)) {
            this.m[i].a(par1ICamera);
         }
      }

      this.h++;
   }

   @Override
   public void playRecord(String par1Str, long par2, int par3, long par4) {
      if (par1Str != null) {
         this.r.w.b("C418 - " + par1Str);
      }

      this.r.C.a(par1Str, (float)par2, par3, (float)par4, 1.0F, 1.0F);
   }

   @Override
   public void a(String par1Str, double par2, double par4, double par6, float par8, float par9) {
      float f = 16.0F;
      if (par8 > 1.0F) {
         f *= par8;
      }

      if (this.r.i.f(par2, par4, par6) < f * f) {
         this.r.C.b(par1Str, (float)par2, (float)par4, (float)par6, par8, par9);
      }
   }

   @Override
   public void a(String par1Str, double par2, double par4, double par6, double par8, double par10, double par12) {
      this.b(par1Str, par2, par4, par6, par8, par10, par12);
   }

   public EntityFX b(String par1Str, double par2, double par4, double par6, double par8, double par10, double par12) {
      if (this.r != null && this.r.i != null && this.r.j != null) {
         int i = this.r.A.Q;
         if (i == 1 && this.i.r.nextInt(3) == 0) {
            i = 2;
         }

         double d = this.r.i.o - par2;
         double d1 = this.r.i.p - par4;
         double d2 = this.r.i.q - par6;
         Object obj = null;
         if (par1Str.equals("hugeexplosion")) {
            this.r.j.a((EntityFX)(obj = new EntityHugeExplodeFX(this.i, par2, par4, par6, par8, par10, par12)));
         } else if (par1Str.equals("largeexplode")) {
            this.r.j.a((EntityFX)(obj = new EntityLargeExplodeFX(this.j, this.i, par2, par4, par6, par8, par10, par12)));
         }

         if (obj != null) {
            return (EntityFX)obj;
         }

         double d3 = 16.0;
         if (d * d + d1 * d1 + d2 * d2 > d3 * d3) {
            return null;
         }

         if (i > 1) {
            return null;
         }

         if (par1Str.equals("bubble")) {
            obj = new EntityBubbleFX(this.i, par2, par4, par6, par8, par10, par12);
         } else if (par1Str.equals("suspended")) {
            obj = new EntitySuspendFX(this.i, par2, par4, par6, par8, par10, par12);
         } else if (par1Str.equals("depthsuspend")) {
            obj = new xy(this.i, par2, par4, par6, par8, par10, par12);
         } else if (par1Str.equals("townaura")) {
            obj = new xy(this.i, par2, par4, par6, par8, par10, par12);
         } else if (par1Str.equals("crit")) {
            obj = new EntityCritFX(this.i, par2, par4, par6, par8, par10, par12);
         } else if (par1Str.equals("magicCrit")) {
            obj = new EntityCritFX(this.i, par2, par4, par6, par8, par10, par12);
            ((EntityFX)obj).b(((EntityFX)obj).o() * 0.3F, ((EntityFX)obj).p() * 0.8F, ((EntityFX)obj).r());
            ((EntityFX)obj).c(((EntityFX)obj).s() + 1);
         } else if (par1Str.equals("smoke")) {
            obj = new EntitySmokeFX(this.i, par2, par4, par6, par8, par10, par12);
         } else if (par1Str.equals("mobSpell")) {
            obj = new EntitySpellParticleFX(this.i, par2, par4, par6, 0.0, 0.0, 0.0);
            ((EntityFX)obj).b((float)par8, (float)par10, (float)par12);
         } else if (par1Str.equals("spell")) {
            obj = new EntitySpellParticleFX(this.i, par2, par4, par6, par8, par10, par12);
         } else if (par1Str.equals("instantSpell")) {
            obj = new EntitySpellParticleFX(this.i, par2, par4, par6, par8, par10, par12);
            ((EntitySpellParticleFX)obj).b(144);
         } else if (par1Str.equals("note")) {
            obj = new EntityNoteFX(this.i, par2, par4, par6, par8, par10, par12);
         } else if (par1Str.equals("portal")) {
            obj = new EntityPortalFX(this.i, par2, par4, par6, par8, par10, par12);
         } else if (par1Str.equals("enchantmenttable")) {
            obj = new afc(this.i, par2, par4, par6, par8, par10, par12);
         } else if (par1Str.equals("explode")) {
            obj = new yx(this.i, par2, par4, par6, par8, par10, par12);
         } else if (par1Str.equals("flame")) {
            obj = new EntityFlameFX(this.i, par2, par4, par6, par8, par10, par12);
         } else if (par1Str.equals("lava")) {
            obj = new EntityLavaFX(this.i, par2, par4, par6);
         } else if (par1Str.equals("footstep")) {
            obj = new EntityFootStepFX(this.j, this.i, par2, par4, par6);
         } else if (par1Str.equals("splash")) {
            obj = new nw(this.i, par2, par4, par6, par8, par10, par12);
         } else if (par1Str.equals("largesmoke")) {
            obj = new EntitySmokeFX(this.i, par2, par4, par6, par8, par10, par12, 2.5F);
         } else if (par1Str.equals("cloud")) {
            obj = new EntityCloudFX(this.i, par2, par4, par6, par8, par10, par12);
         } else if (par1Str.equals("reddust")) {
            obj = new EntityReddustFX(this.i, par2, par4, par6, (float)par8, (float)par10, (float)par12);
         } else if (par1Str.equals("snowballpoof")) {
            obj = new EntityBreakingFX(this.i, par2, par4, par6, Item.aD);
         } else if (par1Str.equals("dripWater")) {
            obj = new EntityDropParticleFX(this.i, par2, par4, par6, acn.g);
         } else if (par1Str.equals("dripLava")) {
            obj = new EntityDropParticleFX(this.i, par2, par4, par6, acn.h);
         } else if (par1Str.equals("snowshovel")) {
            obj = new EntitySnowShovelFX(this.i, par2, par4, par6, par8, par10, par12);
         } else if (par1Str.equals("slime")) {
            obj = new EntityBreakingFX(this.i, par2, par4, par6, Item.aM);
         } else if (par1Str.equals("heart")) {
            obj = new EntityHeartFX(this.i, par2, par4, par6, par8, par10, par12);
         } else if (par1Str.startsWith("iconcrack_")) {
            int j = Integer.parseInt(par1Str.substring(par1Str.indexOf("_") + 1));
            obj = new EntityBreakingFX(this.i, par2, par4, par6, par8, par10, par12, Item.e[j]);
         } else if (par1Str.startsWith("tilecrack_")) {
            int k = Integer.parseInt(par1Str.substring(par1Str.indexOf("_") + 1));
            obj = new EntityDiggingFX(this.i, par2, par4, par6, par8, par10, par12, Block.m[k], 0, 0);
         }

         if (obj != null) {
            this.r.j.a((EntityFX)obj);
         }

         return (EntityFX)obj;
      } else {
         return null;
      }
   }

   @Override
   public void a(Entity par1Entity) {
      par1Entity.S();
      if (par1Entity.Z != null) {
         this.j.a(par1Entity.Z, new mx());
      }

      if (par1Entity.BlockSnowBlock != null) {
         this.j.a(par1Entity.BlockSnowBlock, new mx());
      }
   }

   @Override
   public void b(Entity par1Entity) {
      if (par1Entity.Z != null) {
         this.j.c(par1Entity.Z);
      }

      if (par1Entity.BlockSnowBlock != null) {
         this.j.c(par1Entity.BlockSnowBlock);
      }
   }

   @Override
   public void doNothingWithTileEntity(long i, int j, long k, TileEntity tileentity) {
   }

   public void e() {
      GLAllocation.b(this.q);
   }

   @Override
   public void stupidFuckingMethodSolelyForSprintingBecauseFuckMeIGuess(Entity entity, int option, long x, int y, long z, int blockID, int metadata) {
      double parPosX = entity.o + (this.i.r.nextDouble() - 0.5) * entity.I;
      double parPosY = entity.y.b + 0.1;
      double parPosZ = entity.q + (this.i.r.nextDouble() - 0.5) * entity.I;
      double parMotX = 0.0;
      double parMotY = 0.0;
      double parMotZ = 0.0;
      if (option == 0) {
         parMotX = -entity.r * 4.0;
         parMotY = 1.5;
         parMotZ = -entity.t * 4.0;
      } else if (option == 1) {
         parMotX = 4.0 * (this.i.r.nextDouble() - 0.5);
         parMotY = 0.5;
         parMotZ = (this.i.r.nextDouble() - 0.5) * 4.0;
      }

      this.r.j.a(new EntityDiggingFX(this.i, parPosX, parPosY, parPosZ, parMotX, parMotY, parMotZ, Block.m[blockID], 0, metadata).func_4041_a(x, y, z));
   }

   @Override
   public void playAuxSFX(EntityPlayer par1EntityPlayer, int par2, long par3, int par4, long par5, int par6) {
      Random random = this.i.r;
      switch (par2) {
         case 1000:
            this.i.a(par3, par4, par5, "random.click", 1.0F, 1.0F);
            break;
         case 1001:
            this.i.a(par3, par4, par5, "random.click", 1.0F, 1.2F);
            break;
         case 1002:
            this.i.a(par3, par4, par5, "random.bow", 1.0F, 1.2F);
            break;
         case 1003:
            if (Math.random() < 0.5) {
               this.i.a(par3 + 0.5, par4 + 0.5, par5 + 0.5, "random.door_open", 1.0F, this.i.r.nextFloat() * 0.1F + 0.9F);
            } else {
               this.i.a(par3 + 0.5, par4 + 0.5, par5 + 0.5, "random.door_close", 1.0F, this.i.r.nextFloat() * 0.1F + 0.9F);
            }
            break;
         case 1004:
            this.i.a((float)par3 + 0.5F, par4 + 0.5F, (float)par5 + 0.5F, "random.fizz", 0.5F, 2.6F + (random.nextFloat() - random.nextFloat()) * 0.8F);
            break;
         case 1005:
            if (Item.e[par6] instanceof ItemRecord) {
               this.i.playRecord(((ItemRecord)Item.e[par6]).a, par3, par4, par5);
            } else {
               this.i.playRecord(null, par3, par4, par5);
            }
            break;
         case 1007:
            this.i.a(par3 + 0.5, par4 + 0.5, par5 + 0.5, "mob.ghast.charge", 10.0F, (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F);
            break;
         case 1008:
            this.i.a(par3 + 0.5, par4 + 0.5, par5 + 0.5, "mob.ghast.fireball", 10.0F, (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F);
            break;
         case 1010:
            this.i.a(par3 + 0.5, par4 + 0.5, par5 + 0.5, "mob.zombie.wood", 2.0F, (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F);
            break;
         case 1011:
            this.i.a(par3 + 0.5, par4 + 0.5, par5 + 0.5, "mob.zombie.metal", 2.0F, (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F);
            break;
         case 1012:
            this.i.a(par3 + 0.5, par4 + 0.5, par5 + 0.5, "mob.zombie.woodbreak", 2.0F, (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F);
            break;
         case 2000:
            int i = par6 % 3 - 1;
            int l = par6 / 3 % 3 - 1;
            double d3 = par3 + i * 0.6 + 0.5;
            double d7 = par4 + 0.5;
            double d11 = par5 + l * 0.6 + 0.5;

            for (int l1 = 0; l1 < 10; l1++) {
               double d13 = random.nextDouble() * 0.2 + 0.01;
               double d14 = d3 + i * 0.01 + (random.nextDouble() - 0.5) * l * 0.5;
               double d15 = d7 + (random.nextDouble() - 0.5) * 0.5;
               double d17 = d11 + l * 0.01 + (random.nextDouble() - 0.5) * i * 0.5;
               double d19 = i * d13 + random.nextGaussian() * 0.01;
               double d21 = -0.03 + random.nextGaussian() * 0.01;
               double d23 = l * d13 + random.nextGaussian() * 0.01;
               this.a("smoke", d14, d15, d17, d19, d21, d23);
            }
            break;
         case 2001:
            int j = par6 & 4095;
            if (j > 0) {
               Block block = Block.m[j];
               if (this.r.i.f(par3, par4, par5) < 256.0) {
                  this.r.C.b(block.cb.a(), (float)par3 + 0.5F, par4 + 0.5F, (float)par5 + 0.5F, (block.cb.b() + 1.0F) / 2.0F, block.cb.c() * 0.8F);
               }
            }

            this.r.j.addBlockDestroyEffects(par3, par4, par5, par6 & 4095, par6 >> 12 & 0xFF);
            break;
         case 2002:
            double d1 = par3;
            double d5 = par4;
            double d9 = par5;
            String s1 = "iconcrack_" + Item.bs.bQ;

            for (int j1 = 0; j1 < 8; j1++) {
               this.a(s1, d1, d5, d9, random.nextGaussian() * 0.15, random.nextDouble() * 0.2, random.nextGaussian() * 0.15);
            }

            int k1 = Item.bs.b(par6, 0);
            float f = (k1 >> 16 & 0xFF) / 255.0F;
            float f1 = (k1 >> 8 & 0xFF) / 255.0F;
            float f2 = (k1 >> 0 & 0xFF) / 255.0F;
            String s2 = "spell";
            if (Item.bs.d(par6)) {
               s2 = "instantSpell";
            }

            for (int i2 = 0; i2 < 100; i2++) {
               double d16 = random.nextDouble() * 4.0;
               double d18 = random.nextDouble() * Math.PI * 2.0;
               double d20 = Math.cos(d18) * d16;
               double d22 = 0.01 + random.nextDouble() * 0.5;
               double d24 = Math.sin(d18) * d16;
               EntityFX entityfx = this.b(s2, d1 + d20 * 0.1, d5 + 0.3, d9 + d24 * 0.1, d20, d22, d24);
               if (entityfx != null) {
                  float f3 = 0.75F + random.nextFloat() * 0.25F;
                  entityfx.b(f * f3, f1 * f3, f2 * f3);
                  entityfx.c((float)d16);
               }
            }

            this.i.a(par3 + 0.5, par4 + 0.5, par5 + 0.5, "random.glass", 1.0F, this.i.r.nextFloat() * 0.1F + 0.9F);
            break;
         case 2003:
            double d = par3 + 0.5;
            double d4 = par4;
            double d8 = par5 + 0.5;
            String s = "iconcrack_" + Item.bA.bQ;

            for (int i1 = 0; i1 < 8; i1++) {
               this.a(s, d, d4, d8, random.nextGaussian() * 0.15, random.nextDouble() * 0.2, random.nextGaussian() * 0.15);
            }

            for (double d12 = 0.0; d12 < Math.PI * 2; d12 += Math.PI / 20) {
               this.a("portal", d + Math.cos(d12) * 5.0, d4 - 0.4, d8 + Math.sin(d12) * 5.0, Math.cos(d12) * -5.0, 0.0, Math.sin(d12) * -5.0);
               this.a("portal", d + Math.cos(d12) * 5.0, d4 - 0.4, d8 + Math.sin(d12) * 5.0, Math.cos(d12) * -7.0, 0.0, Math.sin(d12) * -7.0);
            }
            break;
         case 2004:
            for (int k = 0; k < 20; k++) {
               double d2 = par3 + 0.5 + (this.i.r.nextFloat() - 0.5) * 2.0;
               double d6 = par4 + 0.5 + (this.i.r.nextFloat() - 0.5) * 2.0;
               double d10 = par5 + 0.5 + (this.i.r.nextFloat() - 0.5) * 2.0;
               this.i.a("smoke", d2, d6, d10, 0.0, 0.0, 0.0);
               this.i.a("flame", d2, d6, d10, 0.0, 0.0, 0.0);
            }
      }
   }
}
