public class BlockTrapDoor extends Block {
   protected BlockTrapDoor(int par1, acn par2Material) {
      super(par1, par2Material);
      this.bN = 84;
      if (par2Material == acn.f) {
         this.bN++;
      }

      float f = 0.5F;
      float f1 = 1.0F;
      this.a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
   }

   @Override
   public boolean a() {
      return false;
   }

   @Override
   public boolean b() {
      return false;
   }

   @Override
   public boolean getBlocksMovement(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      return !e(par1IBlockAccess.getBlockMetadata(par2, par3, par4));
   }

   @Override
   public int d() {
      return 0;
   }

   @Override
   public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, long par2, int par3, long par4) {
      this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
      return super.getSelectedBoundingBoxFromPool(par1World, par2, par3, par4);
   }

   @Override
   public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, long par2, int par3, long par4) {
      this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
      return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
   }

   @Override
   public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      this.i_(par1IBlockAccess.getBlockMetadata(par2, par3, par4));
   }

   @Override
   public void h() {
      float f = 0.1875F;
      this.a(0.0F, 0.5F - f / 2.0F, 0.0F, 1.0F, 0.5F + f / 2.0F, 1.0F);
   }

   public void i_(int par1) {
      float f = 0.1875F;
      this.a(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
      if (e(par1)) {
         if ((par1 & 3) == 0) {
            this.a(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
         }

         if ((par1 & 3) == 1) {
            this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
         }

         if ((par1 & 3) == 2) {
            this.a(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
         }

         if ((par1 & 3) == 3) {
            this.a(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
         }
      }
   }

   @Override
   public void onBlockClicked(World par1World, long par2, int par3, long par4, EntityPlayer par5EntityPlayer) {
      this.blockActivated(par1World, par2, par3, par4, par5EntityPlayer);
   }

   @Override
   public boolean blockActivated(World par1World, long par2, int par3, long par4, EntityPlayer par5EntityPlayer) {
      if (this.cd == acn.f) {
         return true;
      }

      int i = par1World.getBlockMetadata(par2, par3, par4);
      par1World.setBlockMetadataWithNotify(par2, par3, par4, i ^ 4);
      par1World.playAuxSFXAtEntity(par5EntityPlayer, 1003, par2, par3, par4, 0);
      return true;
   }

   public void onPoweredBlockChange(World par1World, long par2, int par3, long par4, boolean par5) {
      int i = par1World.getBlockMetadata(par2, par3, par4);
      boolean flag = (i & 4) > 0;
      if (flag != par5) {
         par1World.setBlockMetadataWithNotify(par2, par3, par4, i ^ 4);
         par1World.playAuxSFXAtEntity(null, 1003, par2, par3, par4, 0);
      }
   }

   @Override
   public void onNeighborBlockChange(World par1World, long par2, int par3, long par4, int par5) {
      if (!par1World.F) {
         int i = par1World.getBlockMetadata(par2, par3, par4);
         long j = par2;
         long k = par4;
         if ((i & 3) == 0) {
            k++;
         }

         if ((i & 3) == 1) {
            k--;
         }

         if ((i & 3) == 2) {
            j++;
         }

         if ((i & 3) == 3) {
            j--;
         }

         if (!h(par1World.getBlockId(j, par3, k))) {
            par1World.setBlockWithNotify(par2, par3, par4, 0);
            this.dropBlockAsItem(par1World, par2, par3, par4, i, 0);
         }

         boolean flag = par1World.isBlockIndirectlyGettingPowered(par2, par3, par4);
         if (flag || par5 > 0 && Block.m[par5].g() || par5 == 0) {
            this.onPoweredBlockChange(par1World, par2, par3, par4, flag);
         }
      }
   }

   @Override
   public MovingObjectPosition collisionRayTrace(World par1World, long par2, int par3, long par4, bo par5Vec3D, bo par6Vec3D) {
      this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
      return super.collisionRayTrace(par1World, par2, par3, par4, par5Vec3D, par6Vec3D);
   }

   @Override
   public void onBlockPlaced(World par1World, long par2, int par3, long par4, int par5) {
      byte byte0 = 0;
      if (par5 == 2) {
         byte0 = 0;
      }

      if (par5 == 3) {
         byte0 = 1;
      }

      if (par5 == 4) {
         byte0 = 2;
      }

      if (par5 == 5) {
         byte0 = 3;
      }

      par1World.setBlockMetadataWithNotify(par2, par3, par4, byte0);
   }

   @Override
   public boolean canPlaceBlockOnSide(World par1World, long par2, int par3, long par4, int par5) {
      if (par5 == 0) {
         return false;
      }

      if (par5 == 1) {
         return false;
      }

      if (par5 == 2) {
         par4++;
      }

      if (par5 == 3) {
         par4--;
      }

      if (par5 == 4) {
         par2++;
      }

      if (par5 == 5) {
         par2--;
      }

      return h(par1World.getBlockId(par2, par3, par4));
   }

   public static boolean e(int par0) {
      return (par0 & 4) != 0;
   }

   private static boolean h(int par0) {
      if (par0 <= 0) {
         return false;
      }

      Block block = Block.m[par0];
      return block != null && block.cd.j() && block.b() || block == Block.bd;
   }
}
