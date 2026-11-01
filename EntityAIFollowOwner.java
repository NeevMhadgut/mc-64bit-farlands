public class EntityAIFollowOwner extends rc {
   private wd d;
   private EntityLiving e;
   World a;
   private float f;
   private PathNavigate g;
   private int h;
   float b;
   float c;
   private boolean i;

   public EntityAIFollowOwner(wd par1EntityTameable, float par2, float par3, float par4) {
      this.d = par1EntityTameable;
      this.a = par1EntityTameable.k;
      this.f = par2;
      this.g = par1EntityTameable.aM();
      this.c = par3;
      this.b = par4;
      this.a(3);
   }

   public boolean a() {
      EntityLiving entityliving = this.d.ah();
      if (entityliving == null) {
         return false;
      }

      if (this.d.TileEntityMobSpawnerRenderer()) {
         return false;
      }

      if (this.d.f(entityliving) < this.c * this.c) {
         return false;
      }

      this.e = entityliving;
      return true;
   }

   public boolean b() {
      return !this.g.e() && this.d.f(this.e) > this.b * this.b && !this.d.TileEntityMobSpawnerRenderer();
   }

   public void c() {
      this.h = 0;
      this.i = this.d.aM().a();
      this.d.aM().a(false);
   }

   public void d() {
      this.e = null;
      this.g.f();
      this.d.aM().a(this.i);
   }

   public void e() {
      this.d.aJ().a(this.e, 10.0F, this.d.ak());
      if (!this.d.TileEntityMobSpawnerRenderer()) {
         if (--this.h <= 0) {
            this.h = 10;
            if (!this.g.a(this.e, this.f)) {
               if (!(this.d.f(this.e) < 144.0)) {
                  long i = MathHelper.d(this.e.o) - 2L;
                  long j = MathHelper.d(this.e.q) - 2L;
                  int k = MathHelper.c(this.e.y.b);

                  for (int l = 0; l <= 4; l++) {
                     for (int i1 = 0; i1 <= 4; i1++) {
                        if ((l < 1 || i1 < 1 || l > 3 || i1 > 3)
                           && this.a.isBlockNormalCube(i + l, k - 1, j + i1)
                           && !this.a.isBlockNormalCube(i + l, k, j + i1)
                           && !this.a.isBlockNormalCube(i + l, k + 1, j + i1)) {
                           this.d.c(i + l + 0.5, k, j + i1 + 0.5, this.d.u, this.d.v);
                           this.g.f();
                           return;
                        }
                     }
                  }
               }
            }
         }
      }
   }
}
