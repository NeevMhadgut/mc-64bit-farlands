import java.util.Random;

public class WorldGenBigTree extends WorldGenerator {
   static final byte[] a = new byte[]{2, 0, 0, 1, 2, 1};
   Random b;
   World c;
   long[] d = new long[]{0L, 0L, 0L};
   int e;
   int f;
   double g;
   double h;
   double i;
   double j;
   double k;
   int l;
   int m;
   int n;
   long[][] o;

   public WorldGenBigTree(boolean par1) {
      super(par1);
      this.b = new Random();
      this.e = 0;
      this.g = 0.618;
      this.h = 1.0;
      this.i = 0.381;
      this.j = 1.0;
      this.k = 1.0;
      this.l = 1;
      this.m = 12;
      this.n = 5;
   }

   void a() {
      this.f = (int)(this.e * this.g);
      if (this.f >= this.e) {
         this.f = this.e - 1;
      }

      int i = (int)(1.382 + Math.pow(this.k * this.e / 13.0, 2.0));
      if (i < 1) {
         i = 1;
      }

      long[][] ai = new long[i * this.e][4];
      long j = this.d[1] + this.e - this.n;
      int k = 1;
      long l = this.d[1] + this.f;
      int i1 = (int)(j - this.d[1]);
      ai[0][0] = this.d[0];
      ai[0][1] = j;
      ai[0][2] = this.d[2];
      ai[0][3] = l;
      j--;

      while (i1 >= 0) {
         int j1 = 0;
         float f = this.a(i1);
         if (f < 0.0F) {
            j--;
            i1--;
         } else {
            double d = 0.5;

            while (j1 < i) {
               double d1 = this.j * (f * (this.b.nextFloat() + 0.328));
               double d2 = this.b.nextFloat() * 2.0 * Math.PI;
               long k1 = this.d[0] + MathHelper.d(d1 * Math.sin(d2) + d);
               long l1 = this.d[2] + MathHelper.d(d1 * Math.cos(d2) + d);
               long[] ai1 = new long[]{k1, j, l1};
               long[] ai2 = new long[]{k1, j + this.n, l1};
               if (this.checkBlockLine(ai1, ai2) == -1) {
                  long[] ai3 = new long[]{this.d[0], this.d[1], this.d[2]};
                  double d3 = Math.sqrt(Math.pow(Math.abs(this.d[0] - ai1[0]), 2.0) + Math.pow(Math.abs(this.d[2] - ai1[2]), 2.0));
                  double d4 = d3 * this.i;
                  if (ai1[1] - d4 > l) {
                     ai3[1] = l;
                  } else {
                     ai3[1] = (int)(ai1[1] - d4);
                  }

                  if (this.checkBlockLine(ai3, ai1) == -1) {
                     ai[k][0] = k1;
                     ai[k][1] = j;
                     ai[k][2] = l1;
                     ai[k][3] = ai3[1];
                     k++;
                  }
               }

               j1++;
            }

            j--;
            i1--;
         }
      }

      this.o = new long[k][4];
      System.arraycopy(ai, 0, this.o, 0, k);
   }

   void genTreeLayer(long par1, int par2, long par3, float par4, byte par5, int par6) {
      int i = (int)(par4 + 0.618);
      byte byte0 = a[par5];
      byte byte1 = a[par5 + 3];
      long[] ai = new long[]{par1, par2, par3};
      long[] ai1 = new long[]{0L, 0L, 0L};
      int j = -i;
      int k = -i;

      for (ai1[par5] = ai[par5]; j <= i; j++) {
         ai1[byte0] = ai[byte0] + j;
         int l = -i;

         while (l <= i) {
            double d = Math.sqrt(Math.pow(Math.abs(j) + 0.5, 2.0) + Math.pow(Math.abs(l) + 0.5, 2.0));
            if (d > par4) {
               l++;
            } else {
               ai1[byte1] = ai[byte1] + l;
               int i1 = this.c.getBlockId(ai1[0], (int)ai1[1], ai1[2]);
               if (i1 != 0 && i1 != 18) {
                  l++;
               } else {
                  this.setBlockAndMetadata(this.c, ai1[0], (int)ai1[1], ai1[2], par6, 0);
                  l++;
               }
            }
         }
      }
   }

   float a(int par1) {
      if (par1 < this.e * 0.3) {
         return -1.618F;
      }

      float f = this.e / 2.0F;
      float f1 = this.e / 2.0F - par1;
      float f2;
      if (f1 == 0.0F) {
         f2 = f;
      } else if (Math.abs(f1) >= f) {
         f2 = 0.0F;
      } else {
         f2 = (float)Math.sqrt(Math.pow(Math.abs(f), 2.0) - Math.pow(Math.abs(f1), 2.0));
      }

      return f2 * 0.5F;
   }

   float b(int par1) {
      if (par1 >= 0 && par1 < this.n) {
         return par1 != 0 && par1 != this.n - 1 ? 3.0F : 2.0F;
      } else {
         return -1.0F;
      }
   }

   void generateLeafNode(long par1, int par2, long par3) {
      int i = par2;

      for (int j = par2 + this.n; i < j; i++) {
         float f = this.b(i - par2);
         this.genTreeLayer(par1, i, par3, f, (byte)1, 18);
      }
   }

   void placeBlockLine(long[] par1ArrayOfInteger, long[] par2ArrayOfInteger, int par3) {
      int[] ai = new int[]{0, 0, 0};
      byte byte0 = 0;
      int i = 0;

      while (byte0 < 3) {
         ai[byte0] = (int)(par2ArrayOfInteger[byte0] - par1ArrayOfInteger[byte0]);
         if (Math.abs(ai[byte0]) > Math.abs(ai[i])) {
            i = byte0;
         }

         byte0++;
      }

      if (ai[i] != 0) {
         byte byte1 = a[i];
         byte byte2 = a[i + 3];
         byte byte3;
         if (ai[i] > 0) {
            byte3 = 1;
         } else {
            byte3 = -1;
         }

         double d = (double)ai[byte1] / ai[i];
         double d1 = (double)ai[byte2] / ai[i];
         long[] ai1 = new long[]{0L, 0L, 0L};
         int j = 0;

         for (int k = ai[i] + byte3; j != k; j += byte3) {
            ai1[i] = par1ArrayOfInteger[i] + MathHelper.d(j + 0.5);
            ai1[byte1] = par1ArrayOfInteger[byte1] + MathHelper.d(j * d + 0.5);
            ai1[byte2] = par1ArrayOfInteger[byte2] + MathHelper.d(j * d1 + 0.5);
            this.setBlockAndMetadata(this.c, ai1[0], (int)ai1[1], ai1[2], par3, 0);
         }
      }
   }

   void b() {
      int i = 0;

      for (int j = this.o.length; i < j; i++) {
         long k = this.o[i][0];
         long l = this.o[i][1];
         long i1 = this.o[i][2];
         this.generateLeafNode(k, (int)l, i1);
      }
   }

   boolean c(int par1) {
      return par1 >= this.e * 0.2;
   }

   void c() {
      long i = this.d[0];
      long j = this.d[1];
      long k = this.d[1] + this.f;
      long l = this.d[2];
      long[] ai = new long[]{i, j, l};
      long[] ai1 = new long[]{i, k, l};
      this.placeBlockLine(ai, ai1, 17);
      if (this.l == 2) {
         ai[0]++;
         ai1[0]++;
         this.placeBlockLine(ai, ai1, 17);
         ai[2]++;
         ai1[2]++;
         this.placeBlockLine(ai, ai1, 17);
         ai[0]--;
         ai1[0]--;
         this.placeBlockLine(ai, ai1, 17);
      }
   }

   void d() {
      int i = 0;
      int j = this.o.length;
      long[] ai = new long[]{this.d[0], this.d[1], this.d[2]};

      while (i < j) {
         long[] ai1 = this.o[i];
         long[] ai2 = new long[]{ai1[0], ai1[1], ai1[2]};
         ai[1] = ai1[3];
         int k = (int)(ai[1] - this.d[1]);
         if (this.c(k)) {
            this.placeBlockLine(ai, ai2, 17);
         }

         i++;
      }
   }

   int checkBlockLine(long[] par1ArrayOfInteger, long[] par2ArrayOfInteger) {
      int[] ai = new int[]{0, 0, 0};
      byte byte0 = 0;
      int i = 0;

      while (byte0 < 3) {
         ai[byte0] = (int)(par2ArrayOfInteger[byte0] - par1ArrayOfInteger[byte0]);
         if (Math.abs(ai[byte0]) > Math.abs(ai[i])) {
            i = byte0;
         }

         byte0++;
      }

      if (ai[i] == 0) {
         return -1;
      }

      byte byte1 = a[i];
      byte byte2 = a[i + 3];
      byte byte3;
      if (ai[i] > 0) {
         byte3 = 1;
      } else {
         byte3 = -1;
      }

      double d = (double)ai[byte1] / ai[i];
      double d1 = (double)ai[byte2] / ai[i];
      long[] ai1 = new long[]{0L, 0L, 0L};
      int j = 0;

      int k;
      for (k = ai[i] + byte3; j != k; j += byte3) {
         ai1[i] = par1ArrayOfInteger[i] + j;
         ai1[byte1] = par1ArrayOfInteger[byte1] + MathHelper.d(j * d);
         ai1[byte2] = par1ArrayOfInteger[byte2] + MathHelper.d(j * d1);
         int l = this.c.getBlockId(ai1[0], (int)ai1[1], ai1[2]);
         if (l != 0 && l != 18) {
            break;
         }
      }

      return j == k ? -1 : Math.abs(j);
   }

   boolean e() {
      long[] ai = new long[]{this.d[0], this.d[1], this.d[2]};
      long[] ai1 = new long[]{this.d[0], this.d[1] + this.e - 1L, this.d[2]};
      int i = this.c.getBlockId(this.d[0], (int)(this.d[1] - 1L), this.d[2]);
      if (i != 2 && i != 3) {
         return false;
      }

      int j = this.checkBlockLine(ai, ai1);
      if (j == -1) {
         return true;
      }

      if (j < 6) {
         return false;
      }

      this.e = j;
      return true;
   }

   @Override
   public void a(double par1, double par3, double par5) {
      this.m = (int)(par1 * 12.0);
      if (par1 > 0.5) {
         this.n = 5;
      }

      this.j = par3;
      this.k = par5;
   }

   @Override
   public boolean generate(World par1World, Random par2Random, long par3, int par4, long par5) {
      this.c = par1World;
      long l = par2Random.nextLong();
      this.b.setSeed(l);
      this.d[0] = par3;
      this.d[1] = par4;
      this.d[2] = par5;
      if (this.e == 0) {
         this.e = 5 + this.b.nextInt(this.m);
      }

      if (!this.e()) {
         return false;
      }

      this.a();
      this.b();
      this.c();
      this.d();
      return true;
   }
}
