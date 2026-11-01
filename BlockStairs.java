import java.util.ArrayList;
import java.util.Random;

public class BlockStairs extends Block {
   private Block a;

   protected BlockStairs(int par1, Block par2Block) {
      super(par1, par2Block.bN, par2Block.cd);
      this.a = par2Block;
      this.c(par2Block.bP);
      this.b(par2Block.bQ / 3.0F);
      this.a(par2Block.cb);
      this.f(255);
   }

   @Override
   public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   @Override
   public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, long par2, int par3, long par4) {
      return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
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
   public int d() {
      return 10;
   }

   @Override
   public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, long par2, int par3, long par4, int par5) {
      return super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5);
   }

   @Override
   public void getCollidingBoundingBoxes(World par1World, long par2, int par3, long par4, AxisAlignedBB par5AxisAlignedBB, ArrayList par6ArrayList) {
      int i = par1World.getBlockMetadata(par2, par3, par4);
      int j = i & 3;
      float f = 0.0F;
      float f1 = 0.5F;
      float f2 = 0.5F;
      float f3 = 1.0F;
      if ((i & 4) != 0) {
         f = 0.5F;
         f1 = 1.0F;
         f2 = 0.0F;
         f3 = 0.5F;
      }

      this.a(0.0F, f, 0.0F, 1.0F, f1, 1.0F);
      super.getCollidingBoundingBoxes(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList);
      if (j == 0) {
         this.a(0.5F, f2, 0.0F, 1.0F, f3, 1.0F);
         super.getCollidingBoundingBoxes(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList);
      } else if (j == 1) {
         this.a(0.0F, f2, 0.0F, 0.5F, f3, 1.0F);
         super.getCollidingBoundingBoxes(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList);
      } else if (j == 2) {
         this.a(0.0F, f2, 0.5F, 1.0F, f3, 1.0F);
         super.getCollidingBoundingBoxes(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList);
      } else if (j == 3) {
         this.a(0.0F, f2, 0.0F, 1.0F, f3, 0.5F);
         super.getCollidingBoundingBoxes(par1World, par2, par3, par4, par5AxisAlignedBB, par6ArrayList);
      }

      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   @Override
   public void randomDisplayTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      this.a.randomDisplayTick(par1World, par2, par3, par4, par5Random);
   }

   @Override
   public void onBlockClicked(World par1World, long par2, int par3, long par4, EntityPlayer par5EntityPlayer) {
      this.a.onBlockClicked(par1World, par2, par3, par4, par5EntityPlayer);
   }

   @Override
   public void onBlockDestroyedByPlayer(World par1World, long par2, int par3, long par4, int par5) {
      this.a.onBlockDestroyedByPlayer(par1World, par2, par3, par4, par5);
   }

   @Override
   public int getMixedBrightnessForBlock(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      return this.a.getMixedBrightnessForBlock(par1IBlockAccess, par2, par3, par4);
   }

   @Override
   public float getBlockBrightness(IBlockAccess par1IBlockAccess, long par2, int par3, long par4) {
      return this.a.getBlockBrightness(par1IBlockAccess, par2, par3, par4);
   }

   @Override
   public float a(Entity par1Entity) {
      return this.a.a(par1Entity);
   }

   @Override
   public int c() {
      return this.a.c();
   }

   @Override
   public int a(int par1, int par2) {
      return this.a.a(par1, 0);
   }

   @Override
   public int a_(int par1) {
      return this.a.a(par1, 0);
   }

   @Override
   public int e() {
      return this.a.e();
   }

   @Override
   public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, long par2, int par3, long par4) {
      return this.a.getSelectedBoundingBoxFromPool(par1World, par2, par3, par4);
   }

   @Override
   public void velocityToAddToEntity(World par1World, long par2, int par3, long par4, Entity par5Entity, bo par6Vec3D) {
      this.a.velocityToAddToEntity(par1World, par2, par3, par4, par5Entity, par6Vec3D);
   }

   @Override
   public boolean j() {
      return this.a.j();
   }

   @Override
   public boolean a(int par1, boolean par2) {
      return this.a.a(par1, par2);
   }

   @Override
   public boolean canPlaceBlockAt(World par1World, long par2, int par3, long par4) {
      return this.a.canPlaceBlockAt(par1World, par2, par3, par4);
   }

   @Override
   public void onBlockAdded(World par1World, long par2, int par3, long par4) {
      this.onNeighborBlockChange(par1World, par2, par3, par4, 0);
      this.a.onBlockAdded(par1World, par2, par3, par4);
   }

   @Override
   public void onBlockRemoval(World par1World, long par2, int par3, long par4) {
      this.a.onBlockRemoval(par1World, par2, par3, par4);
   }

   @Override
   public void onEntityWalking(World par1World, long par2, int par3, long par4, Entity par5Entity) {
      this.a.onEntityWalking(par1World, par2, par3, par4, par5Entity);
   }

   @Override
   public void updateTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      this.a.updateTick(par1World, par2, par3, par4, par5Random);
   }

   @Override
   public boolean blockActivated(World par1World, long par2, int par3, long par4, EntityPlayer par5EntityPlayer) {
      return this.a.blockActivated(par1World, par2, par3, par4, par5EntityPlayer);
   }

   @Override
   public void onBlockDestroyedByExplosion(World par1World, long par2, int par3, long par4) {
      this.a.onBlockDestroyedByExplosion(par1World, par2, par3, par4);
   }

   @Override
   public void onBlockPlacedBy(World par1World, long par2, int par3, long par4, EntityLiving par5EntityLiving) {
      int i = MathHelper.c(par5EntityLiving.u * 4.0F / 360.0F + 0.5) & 3;
      int j = par1World.getBlockMetadata(par2, par3, par4) & 4;
      if (i == 0) {
         par1World.setBlockMetadataWithNotify(par2, par3, par4, 2 | j);
      }

      if (i == 1) {
         par1World.setBlockMetadataWithNotify(par2, par3, par4, 1 | j);
      }

      if (i == 2) {
         par1World.setBlockMetadataWithNotify(par2, par3, par4, 3 | j);
      }

      if (i == 3) {
         par1World.setBlockMetadataWithNotify(par2, par3, par4, 0 | j);
      }
   }

   @Override
   public void onBlockPlaced(World par1World, long par2, int par3, long par4, int par5) {
      if (par5 == 0) {
         int i = par1World.getBlockMetadata(par2, par3, par4);
         par1World.setBlockMetadataWithNotify(par2, par3, par4, i | 4);
      }
   }
}
