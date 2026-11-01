public class EntityFallingSand extends Entity {
   public int a;
   public int b = 0;

   public EntityFallingSand(World par1World) {
      super(par1World);
   }

   public EntityFallingSand(World par1World, double par2, double par4, double par6, int par8) {
      super(par1World);
      this.a = par8;
      this.h = true;
      this.a(0.98F, 0.98F);
      this.H = this.J / 2.0F;
      this.d(par2, par4, par6);
      this.r = 0.0;
      this.s = 0.0;
      this.t = 0.0;
      this.l = par2;
      this.m = par4;
      this.n = par6;
   }

   @Override
   protected boolean e_() {
      return false;
   }

   @Override
   protected void b() {
   }

   @Override
   public boolean l_() {
      return !this.G;
   }

   @Override
   public void J_() {
      if (this.a == 0) {
         this.A();
      } else {
         this.l = this.o;
         this.m = this.p;
         this.n = this.q;
         this.b++;
         this.s -= 0.04F;
         this.b(this.r, this.s, this.t);
         this.r *= 0.98F;
         this.s *= 0.98F;
         this.t *= 0.98F;
         long i = MathHelper.d(this.o);
         int j = MathHelper.c(this.p);
         long k = MathHelper.d(this.q);
         if (this.b == 1 && this.k.getBlockId(i, j, k) == this.a) {
            this.k.setBlockWithNotify(i, j, k, 0);
         } else if (!this.k.F && this.b == 1) {
            this.A();
         }

         if (this.z) {
            this.r *= 0.7F;
            this.t *= 0.7F;
            this.s *= -0.5;
            if (this.k.getBlockId(i, j, k) != Block.EntityNoteFX.bO) {
               this.A();
               if ((!this.k.canBlockBePlacedAt(this.a, i, j, k, true, 1) || BlockSand.canFallBelow(this.k, i, j - 1, k) || !this.k.setBlockWithNotify(i, j, k, this.a))
                  && !this.k.F) {
                  this.b(this.a, 1);
               }
            }
         } else if (this.b > 100 && !this.k.F && (j < 1 || j > 256) || this.b > 600) {
            this.b(this.a, 1);
            this.A();
         }
      }
   }

   @Override
   protected void b(ady par1NBTTagCompound) {
      par1NBTTagCompound.a("Tile", (byte)this.a);
   }

   @Override
   protected void a(ady par1NBTTagCompound) {
      this.a = par1NBTTagCompound.d("Tile") & 255;
   }

   @Override
   public float h_() {
      return 0.0F;
   }

   public World n() {
      return this.k;
   }
}
