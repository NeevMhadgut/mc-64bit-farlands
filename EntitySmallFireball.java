public class EntitySmallFireball extends EntityFireball {
   public EntitySmallFireball(World par1World) {
      super(par1World);
      this.a(0.3125F, 0.3125F);
   }

   public EntitySmallFireball(World par1World, EntityLiving par2EntityLiving, double par3, double par5, double par7) {
      super(par1World, par2EntityLiving, par3, par5, par7);
      this.a(0.3125F, 0.3125F);
   }

   public EntitySmallFireball(World par1World, double par2, double par4, double par6, double par8, double par10, double par12) {
      super(par1World, par2, par4, par6, par8, par10, par12);
      this.a(0.3125F, 0.3125F);
   }

   @Override
   protected void a(MovingObjectPosition par1MovingObjectPosition) {
      if (!this.k.F) {
         if (par1MovingObjectPosition.g != null) {
            if (!par1MovingObjectPosition.g.F() && par1MovingObjectPosition.g.a(md.a(this, this.a), 5)) {
               par1MovingObjectPosition.g.e(5);
            }
         } else {
            long i = par1MovingObjectPosition.b;
            int j = par1MovingObjectPosition.c;
            long k = par1MovingObjectPosition.d;
            switch (par1MovingObjectPosition.e) {
               case 0:
                  j--;
                  break;
               case 1:
                  j++;
                  break;
               case 2:
                  k--;
                  break;
               case 3:
                  k++;
                  break;
               case 4:
                  i--;
                  break;
               case 5:
                  i++;
            }

            if (this.k.isAirBlock(i, j, k)) {
               this.k.setBlockWithNotify(i, j, k, Block.ar.bO);
            }
         }

         this.A();
      }
   }

   @Override
   public boolean l_() {
      return false;
   }

   @Override
   public boolean a(md par1DamageSource, int par2) {
      return false;
   }
}
