import java.util.ArrayList;
import java.util.Random;

public class BlockStep extends Block {
   public static final String[] a = new String[]{"stone", "sand", "wood", "cobble", "brick", "smoothStoneBrick"};
   private boolean b;

   public BlockStep(int par1, boolean par2) {
      super(par1, 6, acn.e);
      this.b = par2;
      if (!par2) {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
      } else {
         n[par1] = true;
      }

      this.f(255);
   }

   @Override
   public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      if (this.b) {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      } else {
         boolean flag = (par1IBlockAccess.getBlockMetadata(par2, par3, par4) & 8) != 0;
         if (flag) {
            this.a(0.0F, 0.5F, 0.0F, 1.0F, 1.0F, 1.0F);
         } else {
            this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
         }
      }
   }

   @Override
   public void h() {
      if (this.b) {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      } else {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
      }
   }

   @Override
   public void getCollidingBoundingBoxes(World par1World, long par2, int par3, long par4, AxisAlignedBB par5AxisAlignedBB, ArrayList par6ArrayList) {
      this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
      super.getCollidingBoundingBoxes(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList);
   }

   @Override
   public int a(int par1, int par2) {
      int i = par2 & 7;
      if (i == 0) {
         return par1 > 1 ? 5 : 6;
      }

      if (i == 1) {
         if (par1 == 0) {
            return 208;
         } else {
            return par1 != 1 ? 192 : 176;
         }
      } else if (i == 2) {
         return 4;
      } else if (i == 3) {
         return 16;
      } else if (i == 4) {
         return Block.BlockPortal.bN;
      } else {
         return i == 5 ? Block.bm.bN : 6;
      }
   }

   @Override
   public int a_(int par1) {
      return this.a(par1, 0);
   }

   @Override
   public boolean a() {
      return this.b;
   }

   @Override
   public void onBlockPlaced(World par1World, long par2, int par3, long par4, int par5) {
      if (par5 == 0 && !this.b) {
         int i = par1World.getBlockMetadata(par2, par3, par4) & 7;
         par1World.setBlockMetadataWithNotify(par2, par3, par4, i | 8);
      }
   }

   @Override
   public int a(int par1, Random par2Random, int par3) {
      return Block.ak.bO;
   }

   @Override
   public int a(Random par1Random) {
      return !this.b ? 1 : 2;
   }

   @Override
   protected int c(int par1) {
      return par1 & 7;
   }

   @Override
   public boolean b() {
      return this.b;
   }

   @Override
   public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, long par2, int par3, long par4, int par5) {
      if (this.b) {
         super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5);
      }

      if (par5 != 1 && par5 != 0 && !super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5)) {
         return false;
      }

      long i = par2;
      int j = par3;
      long k = par4;
      i += qs.b[qs.a[par5]];
      j += qs.c[qs.a[par5]];
      k += qs.d[qs.a[par5]];
      boolean flag = (par1IBlockAccess.getBlockMetadata(i, j, k) & 8) != 0;
      if (!flag) {
         if (par5 == 1) {
            return true;
         } else {
            return par5 == 0 && super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5)
               ? true
               : par1IBlockAccess.getBlockId(par2, par3, par4) != this.bO || (par1IBlockAccess.getBlockMetadata(par2, par3, par4) & 8) != 0;
         }
      } else if (par5 == 0) {
         return true;
      } else {
         return par5 == 1 && super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5)
            ? true
            : par1IBlockAccess.getBlockId(par2, par3, par4) != this.bO || (par1IBlockAccess.getBlockMetadata(par2, par3, par4) & 8) == 0;
      }
   }

   @Override
   protected ItemStack b(int par1) {
      return new ItemStack(Block.ak.bO, 1, par1 & 7);
   }
}
