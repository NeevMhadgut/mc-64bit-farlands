import java.util.List;
import java.util.Random;

public class ComponentStrongholdPrison extends ComponentStronghold {
   protected final mg a;

   public ComponentStrongholdPrison(int par1, Random par2Random, StructureBoundingBox par3StructureBoundingBox, int par4) {
      super(par1);
      this.h = par4;
      this.a = this.a(par2Random);
      this.g = par3StructureBoundingBox;
   }

   @Override
   public void a(StructureComponent par1StructureComponent, List par2List, Random par3Random) {
      this.getNextComponentNormal((s)par1StructureComponent, par2List, par3Random, 1L, 1);
   }

   public static ComponentStrongholdPrison findValidPlacement(List par0List, Random par1Random, long par2, int par3, long par4, int par5, int par6) {
      StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(par2, par3, par4, -1L, -1, 0L, 9L, 5, 11L, par5);
      return a(structureboundingbox) && StructureComponent.a(par0List, structureboundingbox) == null ? new ComponentStrongholdPrison(par6, par1Random, structureboundingbox, par5) : null;
   }

   @Override
   public boolean a(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox) {
      if (this.a(par1World, par3StructureBoundingBox)) {
         return false;
      }

      this.fillWithRandomizedBlocks(par1World, par3StructureBoundingBox, 0L, 0, 0L, 8L, 4, 10L, true, par2Random, StructureStrongholdPieces.b());
      this.placeDoor(par1World, par2Random, par3StructureBoundingBox, this.a, 1L, 1, 0L);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 1, 10L, 3L, 3, 10L, 0, 0, false);
      this.fillWithRandomizedBlocks(par1World, par3StructureBoundingBox, 4L, 1, 1L, 4L, 3, 1L, false, par2Random, StructureStrongholdPieces.b());
      this.fillWithRandomizedBlocks(par1World, par3StructureBoundingBox, 4L, 1, 3L, 4L, 3, 3L, false, par2Random, StructureStrongholdPieces.b());
      this.fillWithRandomizedBlocks(par1World, par3StructureBoundingBox, 4L, 1, 7L, 4L, 3, 7L, false, par2Random, StructureStrongholdPieces.b());
      this.fillWithRandomizedBlocks(par1World, par3StructureBoundingBox, 4L, 1, 9L, 4L, 3, 9L, false, par2Random, StructureStrongholdPieces.b());
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 4L, 1, 4L, 4L, 3, 6L, Block.EntityAIMoveIndoors.bO, Block.EntityAIMoveIndoors.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 5L, 1, 5L, 7L, 3, 5L, Block.EntityAIMoveIndoors.bO, Block.EntityAIMoveIndoors.bO, false);
      this.placeBlockAtCurrentPosition(par1World, Block.EntityAIMoveIndoors.bO, 0, 4L, 3, 2L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.EntityAIMoveIndoors.bO, 0, 4L, 3, 8L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aL.bO, this.c(Block.aL.bO, 3), 4L, 1, 2L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aL.bO, this.c(Block.aL.bO, 3) + 8, 4L, 2, 2L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aL.bO, this.c(Block.aL.bO, 3), 4L, 1, 8L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.aL.bO, this.c(Block.aL.bO, 3) + 8, 4L, 2, 8L, par3StructureBoundingBox);
      return true;
   }
}
