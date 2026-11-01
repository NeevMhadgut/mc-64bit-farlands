import java.util.List;
import java.util.Random;

public class ComponentStrongholdCrossing extends ComponentStronghold {
   protected final mg a;
   private boolean b;
   private boolean c;
   private boolean d;
   private boolean e;

   public ComponentStrongholdCrossing(int par1, Random par2Random, StructureBoundingBox par3StructureBoundingBox, int par4) {
      super(par1);
      this.h = par4;
      this.a = this.a(par2Random);
      this.g = par3StructureBoundingBox;
      this.b = par2Random.nextBoolean();
      this.c = par2Random.nextBoolean();
      this.d = par2Random.nextBoolean();
      this.e = par2Random.nextInt(3) > 0;
   }

   @Override
   public void a(StructureComponent par1StructureComponent, List par2List, Random par3Random) {
      int i = 3;
      int j = 5;
      if (this.h == 1 || this.h == 2) {
         i = 8 - i;
         j = 8 - j;
      }

      this.getNextComponentNormal((s)par1StructureComponent, par2List, par3Random, 5L, 1);
      if (this.b) {
         this.getNextComponentX((s)par1StructureComponent, par2List, par3Random, i, 1L);
      }

      if (this.c) {
         this.getNextComponentX((s)par1StructureComponent, par2List, par3Random, j, 7L);
      }

      if (this.d) {
         this.getNextComponentZ((s)par1StructureComponent, par2List, par3Random, i, 1L);
      }

      if (this.e) {
         this.getNextComponentZ((s)par1StructureComponent, par2List, par3Random, j, 7L);
      }
   }

   public static ComponentStrongholdCrossing findValidPlacement(List par0List, Random par1Random, long par2, int par3, long par4, int par5, int par6) {
      StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(par2, par3, par4, -4L, -3, 0L, 10L, 9, 11L, par5);
      return a(structureboundingbox) && StructureComponent.a(par0List, structureboundingbox) == null ? new ComponentStrongholdCrossing(par6, par1Random, structureboundingbox, par5) : null;
   }

   @Override
   public boolean a(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox) {
      if (this.a(par1World, par3StructureBoundingBox)) {
         return false;
      }

      this.fillWithRandomizedBlocks(par1World, par3StructureBoundingBox, 0L, 0, 0L, 9L, 8, 10L, true, par2Random, StructureStrongholdPieces.b());
      this.placeDoor(par1World, par2Random, par3StructureBoundingBox, this.a, 4L, 3, 0L);
      if (this.b) {
         this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 3, 1L, 0L, 5, 3L, 0, 0, false);
      }

      if (this.d) {
         this.fillWithBlocks(par1World, par3StructureBoundingBox, 9L, 3, 1L, 9L, 5, 3L, 0, 0, false);
      }

      if (this.c) {
         this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 5, 7L, 0L, 7, 9L, 0, 0, false);
      }

      if (this.e) {
         this.fillWithBlocks(par1World, par3StructureBoundingBox, 9L, 5, 7L, 9L, 7, 9L, 0, 0, false);
      }

      this.fillWithBlocks(par1World, par3StructureBoundingBox, 5L, 1, 10L, 7L, 3, 10L, 0, 0, false);
      this.fillWithRandomizedBlocks(par1World, par3StructureBoundingBox, 1L, 2, 1L, 8L, 2, 6L, false, par2Random, StructureStrongholdPieces.b());
      this.fillWithRandomizedBlocks(par1World, par3StructureBoundingBox, 4L, 1, 5L, 4L, 4, 9L, false, par2Random, StructureStrongholdPieces.b());
      this.fillWithRandomizedBlocks(par1World, par3StructureBoundingBox, 8L, 1, 5L, 8L, 4, 9L, false, par2Random, StructureStrongholdPieces.b());
      this.fillWithRandomizedBlocks(par1World, par3StructureBoundingBox, 1L, 4, 7L, 3L, 4, 9L, false, par2Random, StructureStrongholdPieces.b());
      this.fillWithRandomizedBlocks(par1World, par3StructureBoundingBox, 1L, 3, 5L, 3L, 3, 6L, false, par2Random, StructureStrongholdPieces.b());
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 3, 4L, 3L, 3, 4L, Block.ak.bO, Block.ak.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 4, 6L, 3L, 4, 6L, Block.ak.bO, Block.ak.bO, false);
      this.fillWithRandomizedBlocks(par1World, par3StructureBoundingBox, 5L, 1, 7L, 7L, 1, 8L, false, par2Random, StructureStrongholdPieces.b());
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 5L, 1, 9L, 7L, 1, 9L, Block.ak.bO, Block.ak.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 5L, 2, 7L, 7L, 2, 7L, Block.ak.bO, Block.ak.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 4L, 5, 7L, 4L, 5, 9L, Block.ak.bO, Block.ak.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 8L, 5, 7L, 8L, 5, 9L, Block.ak.bO, Block.ak.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 5L, 5, 7L, 7L, 5, 9L, Block.aj.bO, Block.aj.bO, false);
      this.placeBlockAtCurrentPosition(par1World, Block.aq.bO, 0, 6L, 5, 6L, par3StructureBoundingBox);
      return true;
   }
}
