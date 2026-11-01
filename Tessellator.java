import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.opengl.ARBVertexBufferObject;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;

public class Tessellator {
   private static boolean b = false;
   private static boolean c = false;
   private ByteBuffer d;
   private IntBuffer e;
   private FloatBuffer f;
   private ShortBuffer g;
   private int[] h;
   private int i = 0;
   private double j;
   private double k;
   private int l;
   private int m;
   private boolean n = false;
   private boolean o = false;
   private boolean p = false;
   private boolean q = false;
   private int r = 0;
   private int s = 0;
   private boolean t = false;
   private int u;
   private double v;
   private double w;
   private double x;
   private long xOffsetLong;
   private long yOffsetLong;
   private long zOffsetLong;
   private int y;
   public static final Tessellator a = new Tessellator(2097152);
   private boolean z = false;
   private boolean A = false;
   private IntBuffer B;
   private int C = 0;
   private int D = 10;
   private int E;

   private Tessellator(int par1) {
      this.E = par1;
      this.d = GLAllocation.c(par1 * 4);
      this.e = this.d.asIntBuffer();
      this.f = this.d.asFloatBuffer();
      this.g = this.d.asShortBuffer();
      this.h = new int[par1];
      this.A = c && GLContext.getCapabilities().GL_ARB_vertex_buffer_object;
      if (this.A) {
         this.B = GLAllocation.d(this.D);
         ARBVertexBufferObject.glGenBuffersARB(this.B);
      }
   }

   public int a() {
      if (!this.z) {
         throw new IllegalStateException("Not tesselating!");
      }

      this.z = false;
      if (this.i > 0) {
         ((Buffer)this.e).clear();
         this.e.put(this.h, 0, this.r);
         ((Buffer)this.d).position(0);
         ((Buffer)this.d).limit(this.r * 4);
         if (this.A) {
            this.C = (this.C + 1) % this.D;
            ARBVertexBufferObject.glBindBufferARB(34962, this.B.get(this.C));
            ARBVertexBufferObject.glBufferDataARB(34962, this.d, 35040);
         }

         if (this.o) {
            if (this.A) {
               GL11.glTexCoordPointer(2, 5126, 32, 12L);
            } else {
               ((Buffer)this.f).position(3);
               GL11.glTexCoordPointer(2, 32, this.f);
            }

            GL11.glEnableClientState(32888);
         }

         if (this.p) {
            es.b(es.b);
            if (this.A) {
               GL11.glTexCoordPointer(2, 5122, 32, 28L);
            } else {
               ((Buffer)this.g).position(14);
               GL11.glTexCoordPointer(2, 32, this.g);
            }

            GL11.glEnableClientState(32888);
            es.b(es.a);
         }

         if (this.n) {
            if (this.A) {
               GL11.glColorPointer(4, 5121, 32, 20L);
            } else {
               ((Buffer)this.d).position(20);
               GL11.glColorPointer(4, true, 32, this.d);
            }

            GL11.glEnableClientState(32886);
         }

         if (this.q) {
            if (this.A) {
               GL11.glNormalPointer(5121, 32, 24L);
            } else {
               ((Buffer)this.d).position(24);
               GL11.glNormalPointer(32, this.d);
            }

            GL11.glEnableClientState(32885);
         }

         if (this.A) {
            GL11.glVertexPointer(3, 5126, 32, 0L);
         } else {
            ((Buffer)this.f).position(0);
            GL11.glVertexPointer(3, 32, this.f);
         }

         GL11.glEnableClientState(32884);
         if (this.u == 7 && b) {
            GL11.glDrawArrays(4, 0, this.i);
         } else {
            GL11.glDrawArrays(this.u, 0, this.i);
         }

         GL11.glDisableClientState(32884);
         if (this.o) {
            GL11.glDisableClientState(32888);
         }

         if (this.p) {
            es.b(es.b);
            GL11.glDisableClientState(32888);
            es.b(es.a);
         }

         if (this.n) {
            GL11.glDisableClientState(32886);
         }

         if (this.q) {
            GL11.glDisableClientState(32885);
         }
      }

      int i = this.r * 4;
      this.d();
      return i;
   }

   private void d() {
      this.i = 0;
      ((Buffer)this.d).clear();
      this.r = 0;
      this.s = 0;
   }

   public void b() {
      this.a(7);
   }

   public void a(int par1) {
      if (this.z) {
         throw new IllegalStateException("Already tesselating!");
      }

      this.z = true;
      this.d();
      this.u = par1;
      this.q = false;
      this.n = false;
      this.o = false;
      this.p = false;
      this.t = false;
   }

   public void a(double par1, double par3) {
      this.o = true;
      this.j = par1;
      this.k = par3;
   }

   public void b(int par1) {
      this.p = true;
      this.l = par1;
   }

   public void a(float par1, float par2, float par3) {
      this.a((int)(par1 * 255.0F), (int)(par2 * 255.0F), (int)(par3 * 255.0F));
   }

   public void a(float par1, float par2, float par3, float par4) {
      this.a((int)(par1 * 255.0F), (int)(par2 * 255.0F), (int)(par3 * 255.0F), (int)(par4 * 255.0F));
   }

   public void setColorRGBA_D(double par1, double par2, double par3, double par4) {
      this.a((int)(par1 * 255.0), (int)(par2 * 255.0), (int)(par3 * 255.0), (int)(par4 * 255.0));
   }

   public void a(int par1, int par2, int par3) {
      this.a(par1, par2, par3, 255);
   }

   public void a(int par1, int par2, int par3, int par4) {
      if (!this.t) {
         if (par1 > 255) {
            par1 = 255;
         }

         if (par2 > 255) {
            par2 = 255;
         }

         if (par3 > 255) {
            par3 = 255;
         }

         if (par4 > 255) {
            par4 = 255;
         }

         if (par1 < 0) {
            par1 = 0;
         }

         if (par2 < 0) {
            par2 = 0;
         }

         if (par3 < 0) {
            par3 = 0;
         }

         if (par4 < 0) {
            par4 = 0;
         }

         this.n = true;
         if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
            this.m = par4 << 24 | par3 << 16 | par2 << 8 | par1;
         } else {
            this.m = par1 << 24 | par2 << 16 | par3 << 8 | par4;
         }
      }
   }

   public void a(double par1, double par3, double par5, double par7, double par9) {
      this.a(par7, par9);
      this.a(par1, par3, par5);
   }

   public void a(double par1, double par3, double par5) {
      this.s++;
      if (this.u == 7 && b && this.s % 4 == 0) {
         for (int i = 0; i < 2; i++) {
            int j = 8 * (3 - i);
            if (this.o) {
               this.h[this.r + 3] = this.h[this.r - j + 3];
               this.h[this.r + 4] = this.h[this.r - j + 4];
            }

            if (this.p) {
               this.h[this.r + 7] = this.h[this.r - j + 7];
            }

            if (this.n) {
               this.h[this.r + 5] = this.h[this.r - j + 5];
            }

            this.h[this.r + 0] = this.h[this.r - j + 0];
            this.h[this.r + 1] = this.h[this.r - j + 1];
            this.h[this.r + 2] = this.h[this.r - j + 2];
            this.i++;
            this.r += 8;
         }
      }

      if (this.o) {
         this.h[this.r + 3] = Float.floatToRawIntBits((float)this.j);
         this.h[this.r + 4] = Float.floatToRawIntBits((float)this.k);
      }

      if (this.p) {
         this.h[this.r + 7] = this.l;
      }

      if (this.n) {
         this.h[this.r + 5] = this.m;
      }

      if (this.q) {
         this.h[this.r + 6] = this.y;
      }

      this.h[this.r + 0] = Float.floatToRawIntBits((float)(par1 + this.v));
      this.h[this.r + 1] = Float.floatToRawIntBits((float)(par3 + this.w));
      this.h[this.r + 2] = Float.floatToRawIntBits((float)(par5 + this.x));
      this.r += 8;
      this.i++;
      if (this.i % 4 == 0 && this.r >= this.E - 32) {
         this.a();
         this.z = true;
      }
   }

   public void addVertexWithUVLong(long par1, double par3, long par5, double par7, double par9) {
      this.a(par7, par9);
      this.addVertexLong(par1, par3, par5);
   }

   public void addVertexLong(long par1, double par3, long par5) {
      this.s++;
      if (this.u == 7 && b && this.s % 4 == 0) {
         for (int i = 0; i < 2; i++) {
            int j = 8 * (3 - i);
            if (this.o) {
               this.h[this.r + 3] = this.h[this.r - j + 3];
               this.h[this.r + 4] = this.h[this.r - j + 4];
            }

            if (this.p) {
               this.h[this.r + 7] = this.h[this.r - j + 7];
            }

            if (this.n) {
               this.h[this.r + 5] = this.h[this.r - j + 5];
            }

            this.h[this.r + 0] = this.h[this.r - j + 0];
            this.h[this.r + 1] = this.h[this.r - j + 1];
            this.h[this.r + 2] = this.h[this.r - j + 2];
            this.i++;
            this.r += 8;
         }
      }

      if (this.o) {
         this.h[this.r + 3] = Float.floatToRawIntBits((float)this.j);
         this.h[this.r + 4] = Float.floatToRawIntBits((float)this.k);
      }

      if (this.p) {
         this.h[this.r + 7] = this.l;
      }

      if (this.n) {
         this.h[this.r + 5] = this.m;
      }

      if (this.q) {
         this.h[this.r + 6] = this.y;
      }

      this.h[this.r + 0] = Float.floatToRawIntBits((float)(par1 + this.xOffsetLong));
      this.h[this.r + 1] = Float.floatToRawIntBits((float)(par3 + this.w));
      this.h[this.r + 2] = Float.floatToRawIntBits((float)(par5 + this.zOffsetLong));
      this.r += 8;
      this.i++;
      if (this.i % 4 == 0 && this.r >= this.E - 32) {
         this.a();
         this.z = true;
      }
   }

   public void addVertexWithUVIndependent(double par1, double par3, double par5, double par7, double par9, long xLong, long zLong) {
      this.a(par7, par9);
      this.addVertexIndependent(par1, par3, par5, xLong, zLong);
   }

   public void addVertexIndependent(double par1, double par3, double par5, long xLong, long zLong) {
      this.s++;
      boolean xDistanceCheck = false;
      boolean zDistanceCheck = false;
      if (par1 >= 9.007199E15F || par1 <= -9.007199E15F) {
         xDistanceCheck = true;
      }

      if (par5 >= 9.007199E15F || par5 <= -9.007199E15F) {
         zDistanceCheck = true;
      }

      if (this.u == 7 && b && this.s % 4 == 0) {
         for (int i = 0; i < 2; i++) {
            int j = 8 * (3 - i);
            if (this.o) {
               this.h[this.r + 3] = this.h[this.r - j + 3];
               this.h[this.r + 4] = this.h[this.r - j + 4];
            }

            if (this.p) {
               this.h[this.r + 7] = this.h[this.r - j + 7];
            }

            if (this.n) {
               this.h[this.r + 5] = this.h[this.r - j + 5];
            }

            this.h[this.r + 0] = this.h[this.r - j + 0];
            this.h[this.r + 1] = this.h[this.r - j + 1];
            this.h[this.r + 2] = this.h[this.r - j + 2];
            this.i++;
            this.r += 8;
         }
      }

      if (this.o) {
         this.h[this.r + 3] = Float.floatToRawIntBits((float)this.j);
         this.h[this.r + 4] = Float.floatToRawIntBits((float)this.k);
      }

      if (this.p) {
         this.h[this.r + 7] = this.l;
      }

      if (this.n) {
         this.h[this.r + 5] = this.m;
      }

      if (this.q) {
         this.h[this.r + 6] = this.y;
      }

      if (xDistanceCheck) {
         this.h[this.r + 0] = Float.floatToRawIntBits((float)(xLong + this.xOffsetLong));
      } else {
         this.h[this.r + 0] = Float.floatToRawIntBits((float)(par1 + this.v));
      }

      this.h[this.r + 1] = Float.floatToRawIntBits((float)(par3 + this.w));
      if (zDistanceCheck) {
         this.h[this.r + 2] = Float.floatToRawIntBits((float)(zLong + this.zOffsetLong));
      } else {
         this.h[this.r + 2] = Float.floatToRawIntBits((float)(par5 + this.x));
      }

      this.r += 8;
      this.i++;
      if (this.i % 4 == 0 && this.r >= this.E - 32) {
         this.a();
         this.z = true;
      }
   }

   public void addVertexWithUVNoOffset(double par1, double par3, double par5, double par7, double par9) {
      this.a(par7, par9);
      this.addVertexNoOffset(par1, par3, par5);
   }

   public void addVertexNoOffset(double par1, double par3, double par5) {
      this.s++;
      if (this.u == 7 && b && this.s % 4 == 0) {
         for (int i = 0; i < 2; i++) {
            int j = 8 * (3 - i);
            if (this.o) {
               this.h[this.r + 3] = this.h[this.r - j + 3];
               this.h[this.r + 4] = this.h[this.r - j + 4];
            }

            if (this.p) {
               this.h[this.r + 7] = this.h[this.r - j + 7];
            }

            if (this.n) {
               this.h[this.r + 5] = this.h[this.r - j + 5];
            }

            this.h[this.r + 0] = this.h[this.r - j + 0];
            this.h[this.r + 1] = this.h[this.r - j + 1];
            this.h[this.r + 2] = this.h[this.r - j + 2];
            this.i++;
            this.r += 8;
         }
      }

      if (this.o) {
         this.h[this.r + 3] = Float.floatToRawIntBits((float)this.j);
         this.h[this.r + 4] = Float.floatToRawIntBits((float)this.k);
      }

      if (this.p) {
         this.h[this.r + 7] = this.l;
      }

      if (this.n) {
         this.h[this.r + 5] = this.m;
      }

      if (this.q) {
         this.h[this.r + 6] = this.y;
      }

      this.h[this.r + 0] = Float.floatToRawIntBits((float)par1);
      this.h[this.r + 1] = Float.floatToRawIntBits((float)par3);
      this.h[this.r + 2] = Float.floatToRawIntBits((float)par5);
      this.r += 8;
      this.i++;
      if (this.i % 4 == 0 && this.r >= this.E - 32) {
         this.a();
         this.z = true;
      }
   }

   public void c(int par1) {
      int i = par1 >> 16 & 0xFF;
      int j = par1 >> 8 & 0xFF;
      int k = par1 & 0xFF;
      this.a(i, j, k);
   }

   public void a(int par1, int par2) {
      int i = par1 >> 16 & 0xFF;
      int j = par1 >> 8 & 0xFF;
      int k = par1 & 0xFF;
      this.a(i, j, k, par2);
   }

   public void c() {
      this.t = true;
   }

   public void b(float par1, float par2, float par3) {
      this.q = true;
      byte byte0 = (byte)(par1 * 127.0F);
      byte byte1 = (byte)(par2 * 127.0F);
      byte byte2 = (byte)(par3 * 127.0F);
      this.y = byte0 & 255 | (byte1 & 255) << 8 | (byte2 & 255) << 16;
   }

   public void b(double par1, double par3, double par5) {
      this.v = par1;
      this.w = par3;
      this.x = par5;
   }

   public void setTranslationLong(long par1, long par3, long par5) {
      this.xOffsetLong = par1;
      this.yOffsetLong = par3;
      this.zOffsetLong = par5;
      this.v = par1;
      this.w = par3;
      this.x = par5;
   }

   public void c(float par1, float par2, float par3) {
      this.v += par1;
      this.w += par2;
      this.x += par3;
   }
}
