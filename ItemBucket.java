public class ItemBucket extends Item {
   private int a;

   public ItemBucket(int par1, int par2) {
      super(par1);
      this.bR = 1;
      this.a = par2;
   }

   @Override
   public ItemStack a(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
      float f = 1.0F;
      double d = par3EntityPlayer.l + (par3EntityPlayer.o - par3EntityPlayer.l) * f;
      double d1 = par3EntityPlayer.m + (par3EntityPlayer.p - par3EntityPlayer.m) * f + 1.62 - par3EntityPlayer.H;
      double d2 = par3EntityPlayer.n + (par3EntityPlayer.q - par3EntityPlayer.n) * f;
      boolean flag = this.a == 0;
      MovingObjectPosition movingobjectposition = this.a(par2World, par3EntityPlayer, flag);
      if (movingobjectposition == null) {
         return par1ItemStack;
      }

      if (movingobjectposition.a == aat.a) {
         long i = movingobjectposition.b;
         int j = movingobjectposition.c;
         long k = movingobjectposition.d;
         if (!par2World.canMineBlock(par3EntityPlayer, i, j, k)) {
            return par1ItemStack;
         }

         if (this.a == 0) {
            if (!par3EntityPlayer.canPlayerEdit(i, j, k)) {
               return par1ItemStack;
            }

            if (par2World.getBlockMaterial(i, j, k) == acn.g && par2World.getBlockMetadata(i, j, k) == 0) {
               par2World.setBlockWithNotify(i, j, k, 0);
               if (par3EntityPlayer.aT.d) {
                  return par1ItemStack;
               }

               return new ItemStack(Item.EntityAIAttackOnCollide);
            }

            if (par2World.getBlockMaterial(i, j, k) == acn.h && par2World.getBlockMetadata(i, j, k) == 0) {
               par2World.setBlockWithNotify(i, j, k, 0);
               if (par3EntityPlayer.aT.d) {
                  return par1ItemStack;
               }

               return new ItemStack(Item.StructureNetherBridgeStart);
            }
         } else {
            if (this.a < 0) {
               return new ItemStack(Item.aw);
            }

            if (movingobjectposition.e == 0) {
               j--;
            }

            if (movingobjectposition.e == 1) {
               j++;
            }

            if (movingobjectposition.e == 2) {
               k--;
            }

            if (movingobjectposition.e == 3) {
               k++;
            }

            if (movingobjectposition.e == 4) {
               i--;
            }

            if (movingobjectposition.e == 5) {
               i++;
            }

            if (!par3EntityPlayer.canPlayerEdit(i, j, k)) {
               return par1ItemStack;
            }

            if (par2World.isAirBlock(i, j, k) || !par2World.getBlockMaterial(i, j, k).a()) {
               if (par2World.t.d && this.a == Block.A.bO) {
                  par2World.a(d + 0.5, d1 + 0.5, d2 + 0.5, "random.fizz", 0.5F, 2.6F + (par2World.r.nextFloat() - par2World.r.nextFloat()) * 0.8F);

                  for (int l = 0; l < 8; l++) {
                     par2World.a("largesmoke", i + Math.random(), j + Math.random(), k + Math.random(), 0.0, 0.0, 0.0);
                  }
               } else {
                  par2World.setBlockAndMetadataWithNotify(i, j, k, this.a, 0);
               }

               if (par3EntityPlayer.aT.d) {
                  return par1ItemStack;
               }

               return new ItemStack(Item.aw);
            }
         }
      } else if (this.a == 0 && movingobjectposition.g instanceof un) {
         return new ItemStack(Item.aG);
      }

      return par1ItemStack;
   }
}
