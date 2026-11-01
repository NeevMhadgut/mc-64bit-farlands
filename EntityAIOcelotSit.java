public class EntityAIOcelotSit extends rc {
   private final EntityOcelot a;
   private final float b;
   private int c = 0;
   private int h = 0;
   private int d = 0;
   private long e = 0L;
   private int f = 0;
   private long g = 0L;

   public EntityAIOcelotSit (EntityOcelot par1EntityOcelot, float par2) {
      this.a = par1EntityOcelot;
      this.b = par2;
      this.a(5);
   }

   public boolean a() {
      return this.a.G_() && !this.a.TileEntityMobSpawnerRenderer() && this.a.aO().nextDouble() <= 0.0065F && this.h();
   }

   public boolean b() {
      return this.c <= this.d && this.h <= 60 && this.func_50078_a(this.a.k, this.e, this.f, this.g);
   }

   public void c() {
      this.a.aM().a(this.e + 0.5, this.f + 1, this.g + 0.5, this.b);
      this.c = 0;
      this.h = 0;
      this.d = this.a.aO().nextInt(this.a.aO().nextInt(1200) + 1200) + 1200;
      this.a.ai().a(false);
   }

   public void d() {
      this.a.f(false);
   }

   public void e() {
      this.c++;
      this.a.ai().a(false);
      if (this.a.f(this.e, this.f + 1, this.g) > 1.0) {
         this.a.f(false);
         this.a.aM().a(this.e + 0.5, this.f + 1, this.g + 0.5, this.b);
         this.h++;
      } else if (!this.a.TileEntityMobSpawnerRenderer()) {
         this.a.f(true);
      } else {
         this.h--;
      }
   }

   private boolean h() {
      int i = (int)this.a.p;
      double d = 2.147483647E9;

      for (long j = (long)this.a.o - 8L; j < (long)this.a.o + 8L; j++) {
         for (long k = (long)this.a.q - 8L; k < (long)this.a.q + 8L; k++) {
            if (this.func_50078_a(this.a.k, j, i, k) && this.a.k.isAirBlock(j, i + 1, k)) {
               double d1 = this.a.f(j, i, k);
               if (d1 < d) {
                  this.e = j;
                  this.f = i;
                  this.g = k;
                  d = d1;
               }
            }
         }
      }

      return d < 2.147483647E9;
   }

   private boolean func_50078_a(World par1World, long par2, int par3, long par4) {
      int i = par1World.getBlockId(par2, par3, par4);
      int j = par1World.getBlockMetadata(par2, par3, par4);
      if (i == Block.au.bO) {
         TileEntityChest tileentitychest = (TileEntityChest)par1World.getBlockTileEntity(par2, par3, par4);
         if (tileentitychest.h < 1) {
            return true;
         }
      } else {
         if (i == Block.aC.bO) {
            return true;
         }

         if (i == Block.S.bO && !BlockBed.e(j)) {
            return true;
         }
      }

      return false;
   }
}
