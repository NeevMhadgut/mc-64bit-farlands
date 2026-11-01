public class EntityAIEatGrass extends rc {
   private EntityLiving b;
   private World c;
   int a = 0;

   public EntityAIEatGrass(EntityLiving par1EntityLiving) {
      this.b = par1EntityLiving;
      this.c = par1EntityLiving.k;
      this.a(7);
   }

   public boolean a() {
      if (this.b.aO().nextInt(this.b.bi() ? 50 : 1000) != 0) {
         return false;
      }

      long i = MathHelper.d(this.b.o);
      int j = MathHelper.c(this.b.p);
      long k = MathHelper.d(this.b.q);
      return this.c.getBlockId(i, j, k) == Block.X.bO && this.c.getBlockMetadata(i, j, k) == 1 ? true : this.c.getBlockId(i, j - 1, k) == Block.u.bO;
   }

   public void c() {
      this.a = 40;
      this.c.a(this.b, (byte)10);
      this.b.aM().f();
   }

   public void d() {
      this.a = 0;
   }

   public boolean b() {
      return this.a > 0;
   }

   public int h() {
      return this.a;
   }

   public void e() {
      this.a = Math.max(0, this.a - 1);
      if (this.a == 4) {
         long i = MathHelper.d(this.b.o);
         int j = MathHelper.c(this.b.p);
         long k = MathHelper.d(this.b.q);
         if (this.c.getBlockId(i, j, k) == Block.X.bO) {
            this.c.playAuxSFX(2001, i, j, k, Block.X.bO + 4096);
            this.c.setBlockWithNotify(i, j, k, 0);
            this.b.v();
         } else if (this.c.getBlockId(i, j - 1, k) == Block.u.bO) {
            this.c.playAuxSFX(2001, i, j - 1, k, Block.u.bO);
            this.c.setBlockWithNotify(i, j - 1, k, Block.v.bO);
            this.b.v();
         }
      }
   }
}
