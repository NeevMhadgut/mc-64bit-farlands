import java.util.ArrayList;
import java.util.List;

public class AxisAlignedBB {
   private static List g = new ArrayList();
   private static int h = 0;
   public double a;
   public double b;
   public double c;
   public double d;
   public double e;
   public double f;

   public static AxisAlignedBB a(double par0, double par2, double par4, double par6, double par8, double par10) {
      return new AxisAlignedBB(par0, par2, par4, par6, par8, par10);
   }

   public static void a() {
      g.clear();
      h = 0;
   }

   public static void b() {
      h = 0;
   }

   public static AxisAlignedBB b(double par0, double par2, double par4, double par6, double par8, double par10) {
      if (h >= g.size()) {
         g.add(a(0.0, 0.0, 0.0, 0.0, 0.0, 0.0));
      }

      return ((AxisAlignedBB)g.get(h++)).c(par0, par2, par4, par6, par8, par10);
   }

   private AxisAlignedBB(double par1, double par3, double par5, double par7, double par9, double par11) {
      this.a = par1;
      this.b = par3;
      this.c = par5;
      this.d = par7;
      this.e = par9;
      this.f = par11;
   }

   public AxisAlignedBB c(double par1, double par3, double par5, double par7, double par9, double par11) {
      this.a = par1;
      this.b = par3;
      this.c = par5;
      this.d = par7;
      this.e = par9;
      this.f = par11;
      return this;
   }

   public AxisAlignedBB a(double par1, double par3, double par5) {
      double d = this.a;
      double d1 = this.b;
      double d2 = this.c;
      double d3 = this.d;
      double d4 = this.e;
      double d5 = this.f;
      if (par1 < 0.0) {
         d += par1;
      }

      if (par1 > 0.0) {
         d3 += par1;
      }

      if (par3 < 0.0) {
         d1 += par3;
      }

      if (par3 > 0.0) {
         d4 += par3;
      }

      if (par5 < 0.0) {
         d2 += par5;
      }

      if (par5 > 0.0) {
         d5 += par5;
      }

      return b(d, d1, d2, d3, d4, d5);
   }

   public AxisAlignedBB b(double par1, double par3, double par5) {
      double d = this.a - par1;
      double d1 = this.b - par3;
      double d2 = this.c - par5;
      double d3 = this.d + par1;
      double d4 = this.e + par3;
      double d5 = this.f + par5;
      return b(d, d1, d2, d3, d4, d5);
   }

   public AxisAlignedBB c(double par1, double par3, double par5) {
      return b(this.a + par1, this.b + par3, this.c + par5, this.d + par1, this.e + par3, this.f + par5);
   }

   public double a(AxisAlignedBB par1AxisAlignedBB, double par2) {
      if (par1AxisAlignedBB.e <= this.b || par1AxisAlignedBB.b >= this.e) {
         return par2;
      }

      if (!(par1AxisAlignedBB.f <= this.c) && !(par1AxisAlignedBB.c >= this.f)) {
         if (par2 > 0.0 && par1AxisAlignedBB.d <= this.a) {
            double d = this.a - par1AxisAlignedBB.d;
            if (d < par2) {
               par2 = d;
            }
         }

         if (par2 < 0.0 && par1AxisAlignedBB.a >= this.d) {
            double d1 = this.d - par1AxisAlignedBB.a;
            if (d1 > par2) {
               par2 = d1;
            }
         }

         return par2;
      } else {
         return par2;
      }
   }

   public double b(AxisAlignedBB par1AxisAlignedBB, double par2) {
      if (par1AxisAlignedBB.d <= this.a || par1AxisAlignedBB.a >= this.d) {
         return par2;
      }

      if (!(par1AxisAlignedBB.f <= this.c) && !(par1AxisAlignedBB.c >= this.f)) {
         if (par2 > 0.0 && par1AxisAlignedBB.e <= this.b) {
            double d = this.b - par1AxisAlignedBB.e;
            if (d < par2) {
               par2 = d;
            }
         }

         if (par2 < 0.0 && par1AxisAlignedBB.b >= this.e) {
            double d1 = this.e - par1AxisAlignedBB.b;
            if (d1 > par2) {
               par2 = d1;
            }
         }

         return par2;
      } else {
         return par2;
      }
   }

   public double c(AxisAlignedBB par1AxisAlignedBB, double par2) {
      if (par1AxisAlignedBB.d <= this.a || par1AxisAlignedBB.a >= this.d) {
         return par2;
      }

      if (!(par1AxisAlignedBB.e <= this.b) && !(par1AxisAlignedBB.b >= this.e)) {
         if (par2 > 0.0 && par1AxisAlignedBB.f <= this.c) {
            double d = this.c - par1AxisAlignedBB.f;
            if (d < par2) {
               par2 = d;
            }
         }

         if (par2 < 0.0 && par1AxisAlignedBB.c >= this.f) {
            double d1 = this.f - par1AxisAlignedBB.c;
            if (d1 > par2) {
               par2 = d1;
            }
         }

         return par2;
      } else {
         return par2;
      }
   }

   public boolean a(AxisAlignedBB par1AxisAlignedBB) {
      if (par1AxisAlignedBB.d <= this.a || par1AxisAlignedBB.a >= this.d) {
         return false;
      } else {
         return !(par1AxisAlignedBB.e <= this.b) && !(par1AxisAlignedBB.b >= this.e) ? par1AxisAlignedBB.f > this.c && par1AxisAlignedBB.c < this.f : false;
      }
   }

   public AxisAlignedBB d(double par1, double par3, double par5) {
      this.a += par1;
      this.b += par3;
      this.c += par5;
      this.d += par1;
      this.e += par3;
      this.f += par5;
      return this;
   }

   public boolean a(bo par1Vec3D) {
      if (par1Vec3D.a <= this.a || par1Vec3D.a >= this.d) {
         return false;
      } else {
         return !(par1Vec3D.b <= this.b) && !(par1Vec3D.b >= this.e) ? par1Vec3D.c > this.c && par1Vec3D.c < this.f : false;
      }
   }

   public double c() {
      double d = this.d - this.a;
      double d1 = this.e - this.b;
      double d2 = this.f - this.c;
      return (d + d1 + d2) / 3.0;
   }

   public AxisAlignedBB e(double par1, double par3, double par5) {
      double d = this.a + par1;
      double d1 = this.b + par3;
      double d2 = this.c + par5;
      double d3 = this.d - par1;
      double d4 = this.e - par3;
      double d5 = this.f - par5;
      return b(d, d1, d2, d3, d4, d5);
   }

   public AxisAlignedBB d() {
      return b(this.a, this.b, this.c, this.d, this.e, this.f);
   }

   public MovingObjectPosition a(bo par1Vec3D, bo par2Vec3D) {
      bo vec3d = par1Vec3D.a(par2Vec3D, this.a);
      bo vec3d1 = par1Vec3D.a(par2Vec3D, this.d);
      bo vec3d2 = par1Vec3D.b(par2Vec3D, this.b);
      bo vec3d3 = par1Vec3D.b(par2Vec3D, this.e);
      bo vec3d4 = par1Vec3D.c(par2Vec3D, this.c);
      bo vec3d5 = par1Vec3D.c(par2Vec3D, this.f);
      if (!this.b(vec3d)) {
         vec3d = null;
      }

      if (!this.b(vec3d1)) {
         vec3d1 = null;
      }

      if (!this.c(vec3d2)) {
         vec3d2 = null;
      }

      if (!this.c(vec3d3)) {
         vec3d3 = null;
      }

      if (!this.d(vec3d4)) {
         vec3d4 = null;
      }

      if (!this.d(vec3d5)) {
         vec3d5 = null;
      }

      bo vec3d6 = null;
      if (vec3d != null && (vec3d6 == null || par1Vec3D.e(vec3d) < par1Vec3D.e(vec3d6))) {
         vec3d6 = vec3d;
      }

      if (vec3d1 != null && (vec3d6 == null || par1Vec3D.e(vec3d1) < par1Vec3D.e(vec3d6))) {
         vec3d6 = vec3d1;
      }

      if (vec3d2 != null && (vec3d6 == null || par1Vec3D.e(vec3d2) < par1Vec3D.e(vec3d6))) {
         vec3d6 = vec3d2;
      }

      if (vec3d3 != null && (vec3d6 == null || par1Vec3D.e(vec3d3) < par1Vec3D.e(vec3d6))) {
         vec3d6 = vec3d3;
      }

      if (vec3d4 != null && (vec3d6 == null || par1Vec3D.e(vec3d4) < par1Vec3D.e(vec3d6))) {
         vec3d6 = vec3d4;
      }

      if (vec3d5 != null && (vec3d6 == null || par1Vec3D.e(vec3d5) < par1Vec3D.e(vec3d6))) {
         vec3d6 = vec3d5;
      }

      if (vec3d6 == null) {
         return null;
      }

      byte byte0 = -1;
      if (vec3d6 == vec3d) {
         byte0 = 4;
      }

      if (vec3d6 == vec3d1) {
         byte0 = 5;
      }

      if (vec3d6 == vec3d2) {
         byte0 = 0;
      }

      if (vec3d6 == vec3d3) {
         byte0 = 1;
      }

      if (vec3d6 == vec3d4) {
         byte0 = 2;
      }

      if (vec3d6 == vec3d5) {
         byte0 = 3;
      }

      return new MovingObjectPosition(0L, 0, 0L, byte0, vec3d6);
   }

   private boolean b(bo par1Vec3D) {
      return par1Vec3D == null ? false : par1Vec3D.b >= this.b && par1Vec3D.b <= this.e && par1Vec3D.c >= this.c && par1Vec3D.c <= this.f;
   }

   private boolean c(bo par1Vec3D) {
      return par1Vec3D == null ? false : par1Vec3D.a >= this.a && par1Vec3D.a <= this.d && par1Vec3D.c >= this.c && par1Vec3D.c <= this.f;
   }

   private boolean d(bo par1Vec3D) {
      return par1Vec3D == null ? false : par1Vec3D.a >= this.a && par1Vec3D.a <= this.d && par1Vec3D.b >= this.b && par1Vec3D.b <= this.e;
   }

   public void b(AxisAlignedBB par1AxisAlignedBB) {
      this.a = par1AxisAlignedBB.a;
      this.b = par1AxisAlignedBB.b;
      this.c = par1AxisAlignedBB.c;
      this.d = par1AxisAlignedBB.d;
      this.e = par1AxisAlignedBB.e;
      this.f = par1AxisAlignedBB.f;
   }

   @Override
   public String toString() {
      return "box[" + this.a + ", " + this.b + ", " + this.c + " -> " + this.d + ", " + this.e + ", " + this.f + "]";
   }
}
