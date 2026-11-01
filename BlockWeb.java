import java.util.Random;

public class BlockWeb extends Block {
   public BlockWeb(int par1, int par2) {
      super(par1, par2, acn.D);
   }

   @Override
   public void onEntityCollidedWithBlock(World par1World, long par2, int par3, long par4, Entity par5Entity) {
      par5Entity.q();
   }

   @Override
   public boolean a() {
      return false;
   }

   @Override
   public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, long par2, int par3, long i) {
      return null;
   }

   @Override
   public int d() {
      return 1;
   }

   @Override
   public boolean b() {
      return false;
   }

   @Override
   public int a(int par1, Random par2Random, int par3) {
      return Item.K.bQ;
   }
}
