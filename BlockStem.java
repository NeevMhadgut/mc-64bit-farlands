import java.util.Random;

public class BlockStem extends BlockFlower {
   private Block a;

   protected BlockStem(int par1, Block par2Block) {
      super(par1, 111);
      this.a = par2Block;
      this.a(true);
      float f = 0.125F;
      this.a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
   }

   @Override
   protected boolean f_(int par1) {
      return par1 == Block.aA.bO;
   }

   @Override
   public void updateTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      super.updateTick(par1World, par2, par3, par4, par5Random);
      if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9) {
         float f = this.getGrowthModifier(par1World, par2, par3, par4);
         if (par5Random.nextInt((int)(25.0F / f) + 1) == 0) {
            int i = par1World.getBlockMetadata(par2, par3, par4);
            if (i < 7) {
               par1World.setBlockMetadataWithNotify(par2, par3, par4, ++i);
            } else {
               if (par1World.getBlockId(par2 - 1L, par3, par4) == this.a.bO) {
                  return;
               }

               if (par1World.getBlockId(par2 + 1L, par3, par4) == this.a.bO) {
                  return;
               }

               if (par1World.getBlockId(par2, par3, par4 - 1L) == this.a.bO) {
                  return;
               }

               if (par1World.getBlockId(par2, par3, par4 + 1L) == this.a.bO) {
                  return;
               }

               int j = par5Random.nextInt(4);
               long k = par2;
               long l = par4;
               if (j == 0) {
                  k--;
               }

               if (j == 1) {
                  k++;
               }

               if (j == 2) {
                  l--;
               }

               if (j == 3) {
                  l++;
               }

               int i1 = par1World.getBlockId(k, par3 - 1, l);
               if (par1World.getBlockId(k, par3, l) == 0 && (i1 == Block.aA.bO || i1 == Block.v.bO || i1 == Block.u.bO)) {
                  par1World.setBlockWithNotify(k, par3, l, this.a.bO);
               }
            }
         }
      }
   }

   public void fertilizeStem(World par1World, long par2, int par3, long par4) {
      par1World.setBlockMetadataWithNotify(par2, par3, par4, 7);
   }

   private float getGrowthModifier(World par1World, long par2, int par3, long par4) {
      float f = 1.0F;
      int i = par1World.getBlockId(par2, par3, par4 - 1L);
      int j = par1World.getBlockId(par2, par3, par4 + 1L);
      int k = par1World.getBlockId(par2 - 1L, par3, par4);
      int l = par1World.getBlockId(par2 + 1L, par3, par4);
      int i1 = par1World.getBlockId(par2 - 1L, par3, par4 - 1L);
      int j1 = par1World.getBlockId(par2 + 1L, par3, par4 - 1L);
      int k1 = par1World.getBlockId(par2 + 1L, par3, par4 + 1L);
      int l1 = par1World.getBlockId(par2 - 1L, par3, par4 + 1L);
      boolean flag = k == this.bO || l == this.bO;
      boolean flag1 = i == this.bO || j == this.bO;
      boolean flag2 = i1 == this.bO || j1 == this.bO || k1 == this.bO || l1 == this.bO;

      for (long i2 = par2 - 1L; i2 <= par2 + 1L; i2++) {
         for (long j2 = par4 - 1L; j2 <= par4 + 1L; j2++) {
            int k2 = par1World.getBlockId(i2, par3 - 1, j2);
            float f1 = 0.0F;
            if (k2 == Block.aA.bO) {
               f1 = 1.0F;
               if (par1World.getBlockMetadata(i2, par3 - 1, j2) > 0) {
                  f1 = 3.0F;
               }
            }

            if (i2 != par2 || j2 != par4) {
               f1 /= 4.0F;
            }

            f += f1;
         }
      }

      if (flag2 || flag && flag1) {
         f /= 2.0F;
      }

      return f;
   }

   @Override
   public int d(int par1) {
      int i = par1 * 32;
      int j = 255 - par1 * 8;
      int k = par1 * 4;
      return i << 16 | j << 8 | k;
   }

   @Override
   public int colorMultiplier(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      return this.d(par1IBlockAccess.getBlockMetadata(par2, par3, par4));
   }

   @Override
   public int a(int par1, int par2) {
      return this.bN;
   }

   @Override
   public void h() {
      float f = 0.125F;
      this.a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
   }

   @Override
   public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      this.bZ = (par1IBlockAccess.getBlockMetadata(par2, par3, par4) * 2 + 2) / 16.0F;
      float f = 0.125F;
      this.a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, (float)this.bZ, 0.5F + f);
   }

   @Override
   public int d() {
      return 19;
   }

   public int func_35296_f(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      int i = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
      if (i < 7) {
         return -1;
      } else if (par1IBlockAccess.getBlockId(par2 - 1L, par3, par4) == this.a.bO) {
         return 0;
      } else if (par1IBlockAccess.getBlockId(par2 + 1L, par3, par4) == this.a.bO) {
         return 1;
      } else if (par1IBlockAccess.getBlockId(par2, par3, par4 - 1L) == this.a.bO) {
         return 2;
      } else {
         return par1IBlockAccess.getBlockId(par2, par3, par4 + 1L) != this.a.bO ? -1 : 3;
      }
   }

   @Override
   public void dropBlockAsItemWithChance(World par1World, long par2, int par3, long par4, int par5, float par6, int par7) {
      super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);
      if (!par1World.F) {
         Item item = null;
         if (this.a == Block.ba) {
            item = Item.bg;
         }

         if (this.a == Block.br) {
            item = Item.ItemShears;
         }

         for (int i = 0; i < 3; i++) {
            if (par1World.r.nextInt(15) <= par5) {
               float f = 0.7F;
               float f1 = par1World.r.nextFloat() * f + (1.0F - f) * 0.5F;
               float f2 = par1World.r.nextFloat() * f + (1.0F - f) * 0.5F;
               float f3 = par1World.r.nextFloat() * f + (1.0F - f) * 0.5F;
               EntityItem entityitem = new EntityItem(par1World, (float)par2 + f1, par3 + f2, (float)par4 + f3, new ItemStack(item));
               entityitem.c = 10;
               par1World.a(entityitem);
            }
         }
      }
   }

   @Override
   public int a(int par1, Random par2Random, int par3) {
      if (par1 != 7) {
      }

      return -1;
   }

   @Override
   public int a(Random par1Random) {
      return 1;
   }
}
