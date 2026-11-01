import java.util.Random;

public class BiomeGenDesert extends BiomeGenBase {
   public BiomeGenDesert(int par1) {
      super(par1);
      this.K.clear();
      this.A = (byte)Block.E.bO;
      this.B = (byte)Block.E.bO;
      this.I.z = -999;
      this.I.C = 2;
      this.I.E = 50;
      this.I.F = 10;
   }

   @Override
   public void decorate(World par1World, Random par2Random, long par3, long par4) {
      super.decorate(par1World, par2Random, par3, par4);
      if (par2Random.nextInt(1000) == 0) {
         long i = par3 + par2Random.nextInt(16) + 8L;
         long j = par4 + par2Random.nextInt(16) + 8L;
         WorldGenDesertWells worldgendesertwells = new WorldGenDesertWells();
         worldgendesertwells.generate(par1World, par2Random, i, par1World.getHeightValue(i, j) + 1, j);
      }
   }
}
