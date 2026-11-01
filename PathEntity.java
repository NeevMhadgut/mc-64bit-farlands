public class PathEntity {
   private final e[] a;
   private int b;
   private int c;

   public PathEntity(e[] par1ArrayOfPathPoint) {
      this.a = par1ArrayOfPathPoint;
      this.c = par1ArrayOfPathPoint.length;
   }

   public void a() {
      this.b++;
   }

   public boolean b() {
      return this.b >= this.c;
   }

   public e c() {
      return this.c > 0 ? this.a[this.c - 1] : null;
   }

   public e a(int par1) {
      return this.a[par1];
   }

   public int d() {
      return this.c;
   }

   public void b(int par1) {
      this.c = par1;
   }

   public int e() {
      return this.b;
   }

   public void c(int par1) {
      this.b = par1;
   }

   public bo a(Entity par1Entity, int par2) {
      double d = this.a[par2].a + (int)(par1Entity.I + 1.0F) * 0.5;
      double d1 = this.a[par2].b;
      double d2 = this.a[par2].c + (int)(par1Entity.I + 1.0F) * 0.5;
      return bo.b(d, d1, d2);
   }

   public bo a(Entity par1Entity) {
      return this.a(par1Entity, this.b);
   }

   public boolean a(PathEntity par1PathEntity) {
      if (par1PathEntity == null) {
         return false;
      }

      if (par1PathEntity.a.length != this.a.length) {
         return false;
      }

      for (int i = 0; i < this.a.length; i++) {
         if (this.a[i].a != par1PathEntity.a[i].a || this.a[i].b != par1PathEntity.a[i].b || this.a[i].c != par1PathEntity.a[i].c) {
            return false;
         }
      }

      return true;
   }

   public boolean a(bo par1Vec3D) {
      e pathpoint = this.c();
      return pathpoint == null ? false : pathpoint.a == (long)par1Vec3D.a && pathpoint.c == (long)par1Vec3D.c;
   }
}
