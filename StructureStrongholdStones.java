import java.util.Random;

class StructureStrongholdStones extends StructurePieceBlockSelector {
   private StructureStrongholdStones() {
   }

   @Override
   public void selectBlocks(Random par1Random, long par2, int par3, long par4, boolean par5) {
      if (!par5) {
         this.a = 0;
         this.b = 0;
      } else {
         this.a = Block.bm.bO;
         float f = par1Random.nextFloat();
         if (f < 0.2F) {
            this.b = 2;
         } else if (f < 0.5F) {
            this.b = 1;
         } else if (f < 0.55F) {
            this.a = Block.bl.bO;
            this.b = 2;
         } else {
            this.b = 0;
         }
      }
   }

   StructureStrongholdStones(as par1StructureStrongholdPieceWeight2) {
      this();
   }
}
