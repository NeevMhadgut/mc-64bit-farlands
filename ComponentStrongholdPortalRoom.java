import java.util.List;
import java.util.Random;

public class ComponentStrongholdPortalRoom extends ComponentStronghold {
   private boolean a;

   public ComponentStrongholdPortalRoom(int par1, Random par2Random, StructureBoundingBox par3StructureBoundingBox, int par4) {
      super(par1);
      this.h = par4;
      this.g = par3StructureBoundingBox;
   }

   @Override
   public void a(StructureComponent par1StructureComponent, List par2List, Random par3Random) {
      if (par1StructureComponent != null) {
         ((s)par1StructureComponent).b = this;
      }
   }

   public static ComponentStrongholdPortalRoom findValidPlacement(List par0List, Random par1Random, long par2, int par3, long par4, int par5, int par6) {
      StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(par2, par3, par4, -4L, -1, 0L, 11L, 8, 16L, par5);
      return a(structureboundingbox) && StructureComponent.a(par0List, structureboundingbox) == null ? new ComponentStrongholdPortalRoom(par6, par1Random, structureboundingbox, par5) : null;
   }

   @Override
   public boolean a(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox) {
      this.fillWithRandomizedBlocks(par1World, par3StructureBoundingBox, 0L, 0, 0L, 10L, 7, 15L, false, par2Random, StructureStrongholdPieces.b());
      this.placeDoor(par1World, par2Random, par3StructureBoundingBox, mg.c, 4L, 1, 0L);
      byte byte0 = 6;
      this.fillWithRandomizedBlocks(par1World, par3StructureBoundingBox, 1L, byte0, 1L, 1L, byte0, 14L, false, par2Random, StructureStrongholdPieces.b());
      this.fillWithRandomizedBlocks(par1World, par3StructureBoundingBox, 9L, byte0, 1L, 9L, byte0, 14L, false, par2Random, StructureStrongholdPieces.b());
      this.fillWithRandomizedBlocks(par1World, par3StructureBoundingBox, 2L, byte0, 1L, 8L, byte0, 2L, false, par2Random, StructureStrongholdPieces.b());
      this.fillWithRandomizedBlocks(par1World, par3StructureBoundingBox, 2L, byte0, 14L, 8L, byte0, 14L, false, par2Random, StructureStrongholdPieces.b());
      this.fillWithRandomizedBlocks(par1World, par3StructureBoundingBox, 1L, 1, 1L, 2L, 1, 4L, false, par2Random, StructureStrongholdPieces.b());
      this.fillWithRandomizedBlocks(par1World, par3StructureBoundingBox, 8L, 1, 1L, 9L, 1, 4L, false, par2Random, StructureStrongholdPieces.b());
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 1L, 1, 1L, 1L, 1, 3L, Block.C.bO, Block.C.bO, false);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 9L, 1, 1L, 9L, 1, 3L, Block.C.bO, Block.C.bO, false);
      this.fillWithRandomizedBlocks(par1World, par3StructureBoundingBox, 3L, 1, 8L, 7L, 1, 12L, false, par2Random, StructureStrongholdPieces.b());
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 4L, 1, 9L, 6L, 1, 11L, Block.C.bO, Block.C.bO, false);

      for (int j = 3; j < 14; j += 2) {
         this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 3, j, 0L, 4, j, Block.EntityAIMoveIndoors.bO, Block.EntityAIMoveIndoors.bO, false);
         this.fillWithBlocks(par1World, par3StructureBoundingBox, 10L, 3, j, 10L, 4, j, Block.EntityAIMoveIndoors.bO, Block.EntityAIMoveIndoors.bO, false);
      }

      for (int k = 2; k < 9; k += 2) {
         this.fillWithBlocks(par1World, par3StructureBoundingBox, k, 3, 15L, k, 4, 15L, Block.EntityAIMoveIndoors.bO, Block.EntityAIMoveIndoors.bO, false);
      }

      int l = this.c(Block.bx.bO, 3);
      this.fillWithRandomizedBlocks(par1World, par3StructureBoundingBox, 4L, 1, 5L, 6L, 1, 7L, false, par2Random, StructureStrongholdPieces.b());
      this.fillWithRandomizedBlocks(par1World, par3StructureBoundingBox, 4L, 2, 6L, 6L, 2, 7L, false, par2Random, StructureStrongholdPieces.b());
      this.fillWithRandomizedBlocks(par1World, par3StructureBoundingBox, 4L, 3, 7L, 6L, 3, 7L, false, par2Random, StructureStrongholdPieces.b());

      for (int i1 = 4; i1 <= 6; i1++) {
         this.placeBlockAtCurrentPosition(par1World, Block.bx.bO, l, i1, 1, 4L, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.bx.bO, l, i1, 2, 5L, par3StructureBoundingBox);
         this.placeBlockAtCurrentPosition(par1World, Block.bx.bO, l, i1, 3, 6L, par3StructureBoundingBox);
      }

      byte byte1 = 2;
      byte byte2 = 0;
      byte byte3 = 3;
      byte byte4 = 1;
      switch (this.h) {
         case 0:
            byte1 = 0;
            byte2 = 2;
            break;
         case 1:
            byte1 = 1;
            byte2 = 3;
            byte3 = 0;
            byte4 = 2;
         case 2:
         default:
            break;
         case 3:
            byte1 = 3;
            byte2 = 1;
            byte3 = 0;
            byte4 = 2;
      }

      this.placeBlockAtCurrentPosition(par1World, Block.bI.bO, byte1 + (par2Random.nextFloat() <= 0.9F ? 0 : 4), 4L, 3, 8L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bI.bO, byte1 + (par2Random.nextFloat() <= 0.9F ? 0 : 4), 5L, 3, 8L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bI.bO, byte1 + (par2Random.nextFloat() <= 0.9F ? 0 : 4), 6L, 3, 8L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bI.bO, byte2 + (par2Random.nextFloat() <= 0.9F ? 0 : 4), 4L, 3, 12L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bI.bO, byte2 + (par2Random.nextFloat() <= 0.9F ? 0 : 4), 5L, 3, 12L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bI.bO, byte2 + (par2Random.nextFloat() <= 0.9F ? 0 : 4), 6L, 3, 12L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bI.bO, byte3 + (par2Random.nextFloat() <= 0.9F ? 0 : 4), 3L, 3, 9L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bI.bO, byte3 + (par2Random.nextFloat() <= 0.9F ? 0 : 4), 3L, 3, 10L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bI.bO, byte3 + (par2Random.nextFloat() <= 0.9F ? 0 : 4), 3L, 3, 11L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bI.bO, byte4 + (par2Random.nextFloat() <= 0.9F ? 0 : 4), 7L, 3, 9L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bI.bO, byte4 + (par2Random.nextFloat() <= 0.9F ? 0 : 4), 7L, 3, 10L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.bI.bO, byte4 + (par2Random.nextFloat() <= 0.9F ? 0 : 4), 7L, 3, 11L, par3StructureBoundingBox);
      if (!this.a) {
         int i = this.b(3);
         long j1 = this.getXWithOffset(5L, 6L);
         long k1 = this.getZWithOffset(5L, 6L);
         if (par3StructureBoundingBox.isVecInside(j1, i, k1)) {
            this.a = true;
            par1World.setBlockWithNotify(j1, i, k1, Block.as.bO);
            TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)par1World.getBlockTileEntity(j1, i, k1);
            if (tileentitymobspawner != null) {
               tileentitymobspawner.a("Silverfish");
            }
         }
      }

      return true;
   }
}
