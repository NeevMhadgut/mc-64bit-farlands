import java.util.Random;

public class BlockCrops extends BlockFlower {
   protected BlockCrops(int par1, int par2) {
      super(par1, par2);
      this.bN = par2;
      this.a(true);
      float f = 0.5F;
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
         int i = par1World.getBlockMetadata(par2, par3, par4);
         if (i < 7) {
            float f = this.getGrowthRate(par1World, par2, par3, par4);
            if (par5Random.nextInt((int)(25.0F / f) + 1) == 0) {
               par1World.setBlockMetadataWithNotify(par2, par3, par4, ++i);
            }
         }
      }
   }

   public void fertilize(World par1World, long par2, int par3, long par4) {
      par1World.setBlockMetadataWithNotify(par2, par3, par4, 7);
   }

   private float getGrowthRate(World par1World, long par2, int par3, long par4) {
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
   public int a(int par1, int par2) {
      if (par2 < 0) {
         par2 = 7;
      }

      return this.bN + par2;
   }

   @Override
   public int d() {
      return 6;
   }

   @Override
   public void dropBlockAsItemWithChance(World par1World, long par2, int par3, long par4, int par5, float par6, int par7) {
      super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, 0);
      if (!par1World.F) {
         int i = 3 + par7;

         for (int j = 0; j < i; j++) {
            if (par1World.r.nextInt(15) <= par5) {
               float f = 0.7F;
               double f1 = par1World.r.nextFloat() * f + (1.0F - f) * 0.5F;
               double f2 = par1World.r.nextFloat() * f + (1.0F - f) * 0.5F;
               double f3 = par1World.r.nextFloat() * f + (1.0F - f) * 0.5F;
               EntityItem entityitem = new EntityItem(par1World, par2 + f1, par3 + f2, par4 + f3, new ItemStack(Item.S));
               entityitem.c = 10;
               par1World.a(entityitem);
            }
         }
      }
   }

   @Override
   public int a(int par1, Random par2Random, int par3) {
      return par1 == 7 ? Item.T.bQ : -1;
   }

   @Override
   public int a(Random par1Random) {
      return 1;
   }
}
