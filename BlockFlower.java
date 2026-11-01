import java.util.Random;

public class BlockFlower extends Block {
   protected BlockFlower(int par1, int par2, acn par3Material) {
      super(par1, par3Material);
      this.bN = par2;
      this.a(true);
      float f = 0.2F;
      this.a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 3.0F, 0.5F + f);
   }

   protected BlockFlower(int par1, int par2) {
      this(par1, par2, acn.j);
   }

   @Override
   public boolean canPlaceBlockAt(World par1World, long par2, int par3, long par4) {
      return super.canPlaceBlockAt(par1World, par2, par3, par4) && this.f_(par1World.getBlockId(par2, par3 - 1, par4));
   }

   protected boolean f_(int par1) {
      return par1 == Block.u.bO || par1 == Block.v.bO || par1 == Block.aA.bO;
   }

   @Override
   public void onNeighborBlockChange(World par1World, long par2, int par3, long par4, int par5) {
      super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
      this.checkFlowerChange(par1World, par2, par3, par4);
   }

   @Override
   public void updateTick(World par1World, long par2, int par3, long par4, Random par5Random) {
      this.checkFlowerChange(par1World, par2, par3, par4);
   }

   protected final void checkFlowerChange(World par1World, long par2, int par3, long par4) {
      if (!this.canBlockStay(par1World, par2, par3, par4)) {
         this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
         par1World.setBlockWithNotify(par2, par3, par4, 0);
      }
   }

   @Override
   public boolean canBlockStay(World par1World, long par2, int par3, long par4) {
      return (par1World.getFullBlockLightValue(par2, par3, par4) >= 8 || par1World.canBlockSeeTheSky(par2, par3, par4))
         && this.f_(par1World.getBlockId(par2, par3 - 1, par4));
   }

   @Override
   public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, long par2, int par3, long i) {
      return null;
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
      return 1;
   }
}
