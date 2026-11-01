public class BlockPumpkin extends w {
   private boolean a;

   protected BlockPumpkin(int par1, int par2, boolean par3) {
      super(par1, acn.z);
      this.bN = par2;
      this.a(true);
      this.a = par3;
   }

   public int a(int par1, int par2) {
      if (par1 == 1) {
         return this.bN;
      }

      if (par1 == 0) {
         return this.bN;
      }

      int i = this.bN + 1 + 16;
      if (this.a) {
         i++;
      }

      if (par2 == 2 && par1 == 2) {
         return i;
      } else if (par2 == 3 && par1 == 5) {
         return i;
      } else if (par2 == 0 && par1 == 3) {
         return i;
      } else {
         return par2 == 1 && par1 == 4 ? i : this.bN + 16;
      }
   }

   public int a_(int par1) {
      if (par1 == 1) {
         return this.bN;
      } else if (par1 == 0) {
         return this.bN;
      } else {
         return par1 == 3 ? this.bN + 1 + 16 : this.bN + 16;
      }
   }

   public void onBlockAdded(World par1World, long par2, int par3, long par4) {
      super.onBlockAdded(par1World, par2, par3, par4);
      if (par1World.getBlockId(par2, par3 - 1, par4) == Block.aU.bO && par1World.getBlockId(par2, par3 - 2, par4) == Block.aU.bO) {
         if (!par1World.F) {
            par1World.setBlock(par2, par3, par4, 0);
            par1World.setBlock(par2, par3 - 1, par4, 0);
            par1World.setBlock(par2, par3 - 2, par4, 0);
            q entitysnowman = new q(par1World);
            entitysnowman.c(par2 + 0.5, par3 - 1.95, par4 + 0.5, 0.0F, 0.0F);
            par1World.a(entitysnowman);
            par1World.notifyBlockChange(par2, par3, par4, 0);
            par1World.notifyBlockChange(par2, par3 - 1, par4, 0);
            par1World.notifyBlockChange(par2, par3 - 2, par4, 0);
         }

         for (int i = 0; i < 120; i++) {
            par1World.a(
               "snowshovel", par2 + par1World.r.nextDouble(), par3 - 2 + par1World.r.nextDouble() * 2.5, par4 + par1World.r.nextDouble(), 0.0, 0.0, 0.0
            );
         }
      } else if (par1World.getBlockId(par2, par3 - 1, par4) == Block.ai.bO && par1World.getBlockId(par2, par3 - 2, par4) == Block.ai.bO) {
         boolean flag = par1World.getBlockId(par2 - 1L, par3 - 1, par4) == Block.ai.bO && par1World.getBlockId(par2 + 1L, par3 - 1, par4) == Block.ai.bO;
         boolean flag1 = par1World.getBlockId(par2, par3 - 1, par4 - 1L) == Block.ai.bO && par1World.getBlockId(par2, par3 - 1, par4 + 1L) == Block.ai.bO;
         if (flag || flag1) {
            par1World.setBlock(par2, par3, par4, 0);
            par1World.setBlock(par2, par3 - 1, par4, 0);
            par1World.setBlock(par2, par3 - 2, par4, 0);
            if (flag) {
               par1World.setBlock(par2 - 1L, par3 - 1, par4, 0);
               par1World.setBlock(par2 + 1L, par3 - 1, par4, 0);
            } else {
               par1World.setBlock(par2, par3 - 1, par4 - 1L, 0);
               par1World.setBlock(par2, par3 - 1, par4 + 1L, 0);
            }

            EntityIronGolem entityirongolem = new EntityIronGolem(par1World);
            entityirongolem.b(true);
            entityirongolem.c(par2 + 0.5, par3 - 1.95, par4 + 0.5, 0.0F, 0.0F);
            par1World.a(entityirongolem);

            for (int j = 0; j < 120; j++) {
               par1World.a(
                  "snowballpoof", par2 + par1World.r.nextDouble(), par3 - 2 + par1World.r.nextDouble() * 3.9, par4 + par1World.r.nextDouble(), 0.0, 0.0, 0.0
               );
            }

            par1World.notifyBlockChange(par2, par3, par4, 0);
            par1World.notifyBlockChange(par2, par3 - 1, par4, 0);
            par1World.notifyBlockChange(par2, par3 - 2, par4, 0);
            if (flag) {
               par1World.notifyBlockChange(par2 - 1L, par3 - 1, par4, 0);
               par1World.notifyBlockChange(par2 + 1L, par3 - 1, par4, 0);
            } else {
               par1World.notifyBlockChange(par2, par3 - 1, par4 - 1L, 0);
               par1World.notifyBlockChange(par2, par3 - 1, par4 + 1L, 0);
            }
         }
      }
   }

   public boolean canPlaceBlockAt(World par1World, long par2, int par3, long par4) {
      int i = par1World.getBlockId(par2, par3, par4);
      return (i == 0 || Block.m[i].cd.i()) && par1World.isBlockNormalCube(par2, par3 - 1, par4);
   }

   public void onBlockPlacedBy(World par1World, long par2, int par3, long par4, EntityLiving par5EntityLiving) {
      int i = MathHelper.c(par5EntityLiving.u * 4.0F / 360.0F + 2.5) & 3;
      par1World.setBlockMetadataWithNotify(par2, par3, par4, i);
   }
}
