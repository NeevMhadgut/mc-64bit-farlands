public class EntityExpBottle extends EntityThrowable {
   public EntityExpBottle(World par1World) {
      super(par1World);
   }

   public EntityExpBottle(World par1World, EntityLiving par2EntityLiving) {
      super(par1World, par2EntityLiving);
   }

   public EntityExpBottle(World par1World, double par2, double par4, double par6) {
      super(par1World, par2, par4, par6);
   }

   @Override
   protected float e() {
      return 0.07F;
   }

   @Override
   protected float c() {
      return 0.7F;
   }

   @Override
   protected float d() {
      return -20.0F;
   }

   @Override
   protected void a(MovingObjectPosition par1MovingObjectPosition) {
      if (!this.k.F) {
         String s1 = "iconcrack_" + Item.bs.bQ;

         for (int j1 = 0; j1 < 8; j1++) {
            this.k.a(s1, this.o, this.p, this.q, this.U.nextGaussian() * 0.15, this.U.nextDouble() * 0.2, this.U.nextGaussian() * 0.15);
         }

         int k1 = Item.bs.b(0, 0);
         float f = (k1 >> 16 & 0xFF) / 255.0F;
         float f1 = (k1 >> 8 & 0xFF) / 255.0F;
         float f2 = (k1 >> 0 & 0xFF) / 255.0F;
         String s2 = "spell";
         if (Item.bs.d(0)) {
            s2 = "instantSpell";
         }

         for (int i2 = 0; i2 < 100; i2++) {
            double d16 = this.U.nextDouble() * 4.0;
            double d18 = this.U.nextDouble() * Math.PI * 2.0;
            double d20 = Math.cos(d18) * d16;
            double d22 = 0.01 + this.U.nextDouble() * 0.5;
            double d24 = Math.sin(d18) * d16;
            EntitySpellParticleFX entityfx = new EntitySpellParticleFX(this.k, this.o + d20 * 0.1, this.p + 0.3, this.q + d24 * 0.1, d20, d22, d24);
            entityfx.b(144);
            if (entityfx != null) {
               float f3 = 0.75F + this.U.nextFloat() * 0.25F;
               entityfx.b(f * f3, f1 * f3, f2 * f3);
               entityfx.c((float)d16);
            }
         }

         this.k.a(this.o, this.p, this.q, "random.glass", 1.0F, this.k.r.nextFloat() * 0.1F + 0.9F);
         int i = 3 + this.k.r.nextInt(5) + this.k.r.nextInt(5);

         while (i > 0) {
            int j = EntityXPOrb.b(i);
            i -= j;
            this.k.a(new EntityXPOrb(this.k, this.o, this.p, this.q, j));
         }

         this.A();
      }
   }
}
