import java.util.ArrayList;
import java.util.Random;

public class BlockPistonExtension extends Block {
   private int a = -1;

   public BlockPistonExtension(int par1, int par2) {
      super(par1, par2, acn.E);
      this.a(h);
      this.c(0.5F);
   }

   public void e(int par1) {
      this.a = par1;
   }

   public void v() {
      this.a = -1;
   }

   @Override
   public void onBlockRemoval(World par1World, long par2, int par3, long par4) {
      super.onBlockRemoval(par1World, par2, par3, par4);
      int i = par1World.getBlockMetadata(par2, par3, par4);
      int k = qs.a[h(i)];
      par2 += qs.b[k];
      par3 += qs.c[k];
      par4 += qs.d[k];
      int l = par1World.getBlockId(par2, par3, par4);
      if (l == Block.Z.bO || l == Block.V.bO) {
         int j = par1World.getBlockMetadata(par2, par3, par4);
         if (BlockPistonBase.h(j)) {
            Block.m[l].dropBlockAsItem(par1World, par2, par3, par4, j, 0);
            par1World.setBlockWithNotify(par2, par3, par4, 0);
         }
      }
   }

   @Override
   public int a(int par1, int par2) {
      int i = h(par2);
      if (par1 == i) {
         if (this.a >= 0) {
            return this.a;
         } else {
            return (par2 & 8) != 0 ? this.bN - 1 : this.bN;
         }
      } else {
         return par1 != qs.a[i] ? 108 : 107;
      }
   }

   @Override
   public int d() {
      return 17;
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
   public boolean canPlaceBlockAt(World par1World, long par2, int par3, long i) {
      return false;
   }

   @Override
   public boolean canPlaceBlockOnSide(World par1World, long par2, int par3, long i, int j) {
      return false;
   }

   @Override
   public int a(Random par1Random) {
      return 0;
   }

   @Override
   public void getCollidingBoundingBoxes(World par1World, long par2, int par3, long par4, AxisAlignedBB par5AxisAlignedBB, ArrayList par6ArrayList) {
      int i = par1World.getBlockMetadata(par2, par3, par4);
      switch (h(i)) {
         case 0:
            this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
            super.getCollidingBoundingBoxes(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList);
            this.a(0.375F, 0.25F, 0.375F, 0.625F, 1.0F, 0.625F);
            super.getCollidingBoundingBoxes(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList);
            break;
         case 1:
            this.a(0.0F, 0.75F, 0.0F, 1.0F, 1.0F, 1.0F);
            super.getCollidingBoundingBoxes(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList);
            this.a(0.375F, 0.0F, 0.375F, 0.625F, 0.75F, 0.625F);
            super.getCollidingBoundingBoxes(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList);
            break;
         case 2:
            this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.25F);
            super.getCollidingBoundingBoxes(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList);
            this.a(0.25F, 0.375F, 0.25F, 0.75F, 0.625F, 1.0F);
            super.getCollidingBoundingBoxes(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList);
            break;
         case 3:
            this.a(0.0F, 0.0F, 0.75F, 1.0F, 1.0F, 1.0F);
            super.getCollidingBoundingBoxes(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList);
            this.a(0.25F, 0.375F, 0.0F, 0.75F, 0.625F, 0.75F);
            super.getCollidingBoundingBoxes(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList);
            break;
         case 4:
            this.a(0.0F, 0.0F, 0.0F, 0.25F, 1.0F, 1.0F);
            super.getCollidingBoundingBoxes(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList);
            this.a(0.375F, 0.25F, 0.25F, 0.625F, 0.75F, 1.0F);
            super.getCollidingBoundingBoxes(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList);
            break;
         case 5:
            this.a(0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            super.getCollidingBoundingBoxes(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList);
            this.a(0.0F, 0.375F, 0.25F, 0.75F, 0.625F, 0.75F);
            super.getCollidingBoundingBoxes(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList);
      }

      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   @Override
   public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      int i = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
      switch (h(i)) {
         case 0:
            this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
            break;
         case 1:
            this.a(0.0F, 0.75F, 0.0F, 1.0F, 1.0F, 1.0F);
            break;
         case 2:
            this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.25F);
            break;
         case 3:
            this.a(0.0F, 0.0F, 0.75F, 1.0F, 1.0F, 1.0F);
            break;
         case 4:
            this.a(0.0F, 0.0F, 0.0F, 0.25F, 1.0F, 1.0F);
            break;
         case 5:
            this.a(0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      }
   }

   @Override
   public void onNeighborBlockChange(World par1World, long par2, int par3, long par4, int par5) {
      int i = h(par1World.getBlockMetadata(par2, par3, par4));
      int j = par1World.getBlockId(par2 - qs.b[i], par3 - qs.c[i], par4 - qs.d[i]);
      if (j != Block.Z.bO && j != Block.V.bO) {
         par1World.setBlockWithNotify(par2, par3, par4, 0);
      } else {
         Block.m[j].onNeighborBlockChange(par1World, par2 - qs.b[i], par3 - qs.c[i], par4 - qs.d[i], par5);
      }
   }

   public static int h(int par0) {
      return par0 & 7;
   }
}
