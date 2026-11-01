public class ItemDye extends Item {
   public static final String[] a = new String[]{
      "black", "red", "green", "brown", "blue", "purple", "cyan", "silver", "gray", "pink", "lime", "yellow", "lightBlue", "magenta", "orange", "white"
   };
   public static final int[] b = new int[]{
      1973019, 11743532, 3887386, 5320730, 2437522, 8073150, 2651799, 2651799, 4408131, 14188952, 4312372, 14602026, 6719955, 12801229, 15435844, 15790320
   };

   public ItemDye(int par1) {
      super(par1);
      this.a(true);
      this.g(0);
   }

   @Override
   public int b(int par1) {
      int i = MathHelper.a(par1, 0, 15);
      return this.bS + i % 8 * 16 + i / 8;
   }

   @Override
   public String a(ItemStack par1ItemStack) {
      int i = MathHelper.a(par1ItemStack.i(), 0, 15);
      return super.e() + "." + a[i];
   }

   @Override
   public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, long par4, int par5, long par6, int par7) {
      if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6)) {
         return false;
      }

      if (par1ItemStack.i() == 15) {
         int i = par3World.getBlockId(par4, par5, par6);
         if (i == Block.y.bO) {
            if (!par3World.F) {
               ((BlockSapling)Block.y).growTree(par3World, par4, par5, par6, par3World.r);
               par1ItemStack.a--;
            }

            return true;
         } else if (i != Block.TileEntityMobSpawnerRenderer.bO && i != Block.ag.bO) {
            if (i != Block.EntityFireball.bO && i != Block.bs.bO) {
               if (i == Block.TileEntityDispenser.bO) {
                  if (!par3World.F) {
                     ((BlockCrops)Block.TileEntityDispenser).fertilize(par3World, par4, par5, par6);
                     par1ItemStack.a--;
                  }

                  return true;
               } else if (i == Block.bD.bO) {
                  if (!par3World.F) {
                     par3World.setBlockMetadataWithNotify(par4, par5, par6, 3);
                     par1ItemStack.a--;
                  }

                  return true;
               } else if (i == Block.u.bO) {
                  if (!par3World.F) {
                     par1ItemStack.a--;

                     label80:
                     for (int j = 0; j < 128; j++) {
                        long k = par4;
                        int l = par5 + 1;
                        long i1 = par6;

                        for (int j1 = 0; j1 < j / 16; j1++) {
                           k += d.nextInt(3) - 1;
                           l += (d.nextInt(3) - 1) * d.nextInt(3) / 2;
                           i1 += d.nextInt(3) - 1;
                           if (par3World.getBlockId(k, l - 1, i1) != Block.u.bO || par3World.isBlockNormalCube(k, l, i1)) {
                              continue label80;
                           }
                        }

                        if (par3World.getBlockId(k, l, i1) == 0) {
                           if (d.nextInt(10) != 0) {
                              par3World.setBlockAndMetadataWithNotify(k, l, i1, Block.X.bO, 1);
                           } else if (d.nextInt(3) != 0) {
                              par3World.setBlockWithNotify(k, l, i1, Block.ad.bO);
                           } else {
                              par3World.setBlockWithNotify(k, l, i1, Block.BlockTNT.bO);
                           }
                        }
                     }
                  }

                  return true;
               } else {
                  return false;
               }
            } else {
               if (!par3World.F) {
                  ((BlockStem)Block.m[i]).fertilizeStem(par3World, par4, par5, par6);
                  par1ItemStack.a--;
               }

               return true;
            }
         } else {
            if (!par3World.F && ((BlockMushroom)Block.m[i]).fertilizeMushroom(par3World, par4, par5, par6, par3World.r)) {
               par1ItemStack.a--;
            }

            return true;
         }
      } else {
         return false;
      }
   }

   @Override
   public void a(ItemStack par1ItemStack, EntityLiving par2EntityLiving) {
      if (par2EntityLiving instanceof cu) {
         cu entitysheep = (cu)par2EntityLiving;
         int i = BlockCloth.e(par1ItemStack.i());
         if (!entitysheep.u() && entitysheep.t() != i) {
            entitysheep.c_(i);
            par1ItemStack.a--;
         }
      }
   }
}
