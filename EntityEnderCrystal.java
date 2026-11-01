public class EntityEnderCrystal extends Entity {
   public int a = 0;
   public int b;

   public EntityEnderCrystal(World par1World) {
      super(par1World);
      this.h = true;
      this.a(2.0F, 2.0F);
      this.H = this.J / 2.0F;
      this.b = 5;
      this.a = this.U.nextInt(100000);
   }

   public EntityEnderCrystal(World par1World, double par2, double par4, double par6) {
      this(par1World);
      this.d(par2, par4, par6);
   }

   @Override
   protected boolean e_() {
      return false;
   }

   @Override
   protected void b() {
      this.EntityNoteFX.a(8, this.b);
   }

   @Override
   public void J_() {
      this.l = this.o;
      this.m = this.p;
      this.n = this.q;
      this.a++;
      this.EntityNoteFX.b(8, this.b);
      long i = MathHelper.d(this.o);
      int j = MathHelper.c(this.p);
      long k = MathHelper.d(this.q);
      if (this.k.getBlockId(i, j, k) != Block.ar.bO) {
         this.k.setBlockWithNotify(i, j, k, Block.ar.bO);
      }
   }

   @Override
   protected void b(ady nbttagcompound) {
   }

   @Override
   protected void a(ady nbttagcompound) {
   }

   @Override
   public float h_() {
      return 0.0F;
   }

   @Override
   public boolean l_() {
      return true;
   }

   @Override
   public boolean a(md par1DamageSource, int par2) {
      if (!this.G && !this.k.F) {
         this.b = 0;
         if (this.b <= 0) {
            if (!this.k.F) {
               this.A();
               this.k.a(null, this.o, this.p, this.q, 6.0F);
            } else {
               this.A();
            }
         }
      }

      return true;
   }
}
